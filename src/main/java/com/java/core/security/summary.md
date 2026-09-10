# Java Security Interview Summary

## 1. Secure Programming Practices

Secure programming means designing and implementing software to prevent unauthorized access, data exposure, manipulation, and common vulnerabilities.

### Key Practices

* Validate and sanitize input.
* Use parameterized queries instead of SQL concatenation.
* Encode output where appropriate.
* Use Spring Security for authentication and authorization.
* Protect against CSRF when applicable.
* Never store passwords as plain text.
* Avoid insecure Java deserialization.
* Never expose sensitive information in logs or error responses.
* Apply the principle of least privilege.
* Keep dependencies and frameworks patched.
* Use HTTPS/TLS.
* Implement secure session and token management.
* Store secrets securely instead of hardcoding them.
* Follow OWASP security recommendations.

### Interview Answer

> "I treat security as part of the application design, not something added after development. I validate input, enforce authentication and authorization, use parameterized queries, protect sessions and tokens, avoid unsafe deserialization, and follow OWASP recommendations."

---

# 2. SQL Injection

SQL injection occurs when untrusted input is directly incorporated into a SQL statement.

### Vulnerable

```java
String sql = "SELECT * FROM users WHERE username = '"
           + username + "'";
```

### Safe

Use parameterized queries:

```java
String sql = "SELECT * FROM users WHERE username = ?";

PreparedStatement statement =
        connection.prepareStatement(sql);

statement.setString(1, username);
```

With Spring Data JPA:

```java
@Query("SELECT u FROM User u WHERE u.username = :username")
Optional<User> findByUsername(
        @Param("username") String username);
```

### Key Point

> Never construct SQL by concatenating untrusted input. Use prepared statements, parameterized queries, or properly managed ORM queries.

---

# 3. Does JPA/Hibernate Prevent SQL Injection?

No.

JPA/Hibernate reduces the risk when used correctly, but developers can still introduce vulnerabilities through native SQL or dynamically constructed queries.

### Unsafe

```java
String sql =
    "SELECT * FROM users WHERE name = '" + name + "'";
```

### Interview Answer

> "ORMs help prevent SQL injection when used correctly, but they don't eliminate the developer's responsibility to avoid dynamically concatenating untrusted input into queries."

---

# 4. Cross-Site Scripting (XSS)

XSS occurs when an attacker injects malicious JavaScript into content that is later rendered in another user's browser.

### Prevention

* Validate input.
* Encode output.
* Use frameworks that automatically escape HTML.
* Avoid rendering untrusted raw HTML.
* Use Content Security Policy where appropriate.
* Set secure cookie attributes.

### Thymeleaf

Prefer:

```html
<p th:text="${username}"></p>
```

over rendering untrusted content as raw HTML.

---

# 5. Cross-Site Request Forgery (CSRF)

CSRF tricks an authenticated user's browser into sending an unwanted request to an application.

### Example

```text
User logs into bank.com
        ↓
User visits malicious-site.com
        ↓
Malicious site causes browser to send request
        ↓
Browser automatically includes authentication cookie
        ↓
Bank receives the request as the authenticated user
```

### Spring Security

Spring Security provides CSRF protection for applications using cookie-based authentication.

```java
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {

    http.csrf(csrf -> csrf
        .csrfTokenRepository(
            CookieCsrfTokenRepository.withHttpOnlyFalse()
        )
    );

    return http.build();
}
```

### Important Interview Nuance

CSRF is particularly relevant when browsers automatically send credentials, such as session cookies.

For a properly designed stateless API using bearer tokens in the `Authorization` header, the CSRF threat model is different.

Do **not** simply say:

> "Disable CSRF for REST APIs."

Instead:

> "I configure CSRF according to the authentication architecture. I only disable it when CSRF is not applicable, such as an appropriately designed stateless bearer-token API."

---

# 6. Insecure Deserialization

Insecure deserialization occurs when an application deserializes untrusted data without sufficiently controlling what objects can be created.

### Risky Java Serialization

```java
ObjectInputStream input =
        new ObjectInputStream(untrustedInput);

Object object = input.readObject();
```

### Preferred Approach

Use explicit data formats such as JSON and controlled DTOs.

```java
public record UserRequest(
    String username,
    int age
) {}
```

### Interview Answer

> "I avoid Java native serialization for untrusted data. For APIs, I prefer JSON mapped to explicit DTOs and restrict the types that can be deserialized."

---

# 7. Broken Authentication

Broken authentication occurs when authentication or session management is incorrectly implemented.

### Examples

* Weak passwords.
* Plain-text passwords.
* Weak password hashing.
* Predictable session IDs.
* Session fixation.
* Tokens that never expire.
* Poor logout handling.
* Missing brute-force protection.
* Weak credential recovery.
* Incorrect JWT validation.

### Spring Security

Use established security frameworks rather than implementing authentication manually.

```java
@Bean
PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

```java
String hash = passwordEncoder.encode(password);

boolean valid =
        passwordEncoder.matches(password, hash);
```

---

# 8. Password Hashing vs Encryption

Passwords should generally be **hashed**, not encrypted.

### Encryption

```text
password
   ↓
encrypted value
   ↓
password
```

Encryption is reversible.

### Hashing

```text
password
   ↓
hash
```

Hashing is designed to be one-way.

Use password-specific algorithms such as:

* BCrypt
* Argon2
* PBKDF2

Avoid obsolete/general-purpose hashes such as:

* MD5
* SHA-1

---

# 9. Authentication vs Authorization

| Concept        | Question         | Example                  |
| -------------- | ---------------- | ------------------------ |
| Authentication | Who are you?     | Login                    |
| Authorization  | What can you do? | ADMIN can delete users   |
| Auditing       | What did you do? | Payment modification log |

### Interview Answer

> "Authentication establishes identity; authorization determines permissions."

---

# 10. Broken Authorization / Broken Access Control

A user being authenticated does not mean they are authorized to perform every operation.

### Example

```text
GET /users/123
```

A logged-in user should not automatically be able to access user `123`.

### Spring Security

```java
@PreAuthorize("hasRole('ADMIN')")
public void deleteUser(Long id) {
    ...
}
```

Authorization may also need to happen at the business/resource level:

```java
if (!userOwnsResource(currentUser, resource)) {
    throw new AccessDeniedException("Forbidden");
}
```

### Key Principle

> Never rely on the frontend to enforce authorization. Authorization must be enforced server-side.

---

# 11. IDOR

**Insecure Direct Object Reference** occurs when an application exposes an object identifier without verifying whether the current user is allowed to access that object.

### Example

```text
GET /accounts/1001
```

Attacker changes it to:

```text
GET /accounts/1002
```

and gains access to another user's account.

### Prevention

Verify ownership or permissions:

```java
Account account = accountRepository.findById(accountId)
        .orElseThrow();

if (!account.getOwnerId().equals(currentUser.getId())) {
    throw new AccessDeniedException("Forbidden");
}
```

### Key Point

> Hiding IDs is not a security control. The server must verify authorization.

---

# 12. Command Injection

Command injection occurs when user-controlled input is incorporated into an operating-system command.

### Dangerous

```java
Runtime.getRuntime().exec(
    "ping " + userInput
);
```

### Prevention

* Avoid OS commands when possible.
* Don't invoke a shell unnecessarily.
* Validate input using an allowlist.
* Pass arguments separately.
* Apply least privilege.

Example:

```java
new ProcessBuilder(
    "ping",
    "-c",
    "1",
    validatedHost
);
```

---

# 13. Path Traversal

Path traversal occurs when an attacker manipulates a file path to access files outside the intended directory.

### Attack Example

```text
/download?file=../../../../etc/passwd
```

### Safer Approach

```java
Path base =
    Paths.get("/files")
         .toAbsolutePath()
         .normalize();

Path requested =
    base.resolve(filename)
        .normalize();

if (!requested.startsWith(base)) {
    throw new SecurityException("Invalid path");
}
```

### Key Point

> Normalize and validate the final resolved path before accessing the filesystem.

---

# 14. JWT Security

JWTs are commonly used to represent claims about an authenticated user.

```text
Header.Payload.Signature
```

### Security Considerations

Always validate:

* Signature.
* Algorithm.
* Expiration (`exp`).
* Issuer (`iss`).
* Audience (`aud`) where applicable.

Also:

* Use HTTPS.
* Use short-lived access tokens.
* Protect refresh tokens.
* Rotate/revoke credentials where appropriate.
* Don't put secrets into JWT claims.

### Important

JWT payloads are normally **encoded, not encrypted**.

Therefore, don't put passwords, secrets, or sensitive information into JWT payloads.

---

# 15. Sensitive Data Exposure

Sensitive information can accidentally be exposed through:

* API responses.
* Logs.
* Exception messages.
* Database records.
* Configuration files.
* Source code.
* Git repositories.

### Bad Response

```json
{
  "username": "john",
  "passwordHash": "...",
  "creditCard": "..."
}
```

### Better

```json
{
  "username": "john"
}
```

Use DTOs to explicitly control what leaves the application.

---

# 16. Should Passwords and Tokens Be Logged?

**No.**

Never log:

* Passwords.
* Authorization headers.
* JWTs.
* Refresh tokens.
* API keys.
* Credit-card information.
* Other sensitive credentials.

### Example

Instead of:

```text
Authorization: Bearer eyJhbGciOi...
```

use:

```text
Authorization: Bearer ******
```

### Key Point

> Logs often have broader access than the application itself, so sensitive data in logs can become a security vulnerability.

---

# 17. Security Misconfiguration

Security misconfiguration occurs when applications or infrastructure are deployed with insecure settings.

### Examples

```text
debug=true
```

Exposing sensitive actuator endpoints:

```text
/actuator/env
/actuator/heapdump
```

Overly permissive CORS:

```text
Access-Control-Allow-Origin: *
```

Exposing stack traces:

```text
500 Internal Server Error
java.sql.SQLException: ...
database.internal...
```

### Prevention

* Secure production configuration.
* Disable unnecessary endpoints.
* Avoid exposing stack traces.
* Apply least privilege.
* Review CORS configuration.
* Configure security headers.
* Keep dependencies patched.

---

# 18. CORS

**CORS = Cross-Origin Resource Sharing**

CORS controls which browser origins are allowed to access resources from another origin.

Example:

```text
frontend.example.com
        ↓
api.example.com
```

The API can explicitly allow the frontend origin.

### Important

CORS is:

* A browser security mechanism.
* Not authentication.
* Not authorization.

Don't use CORS as a replacement for access control.

---

# 19. Security Headers

Common security headers include:

```text
Content-Security-Policy
X-Content-Type-Options
Strict-Transport-Security
Referrer-Policy
```

Spring Security can configure security headers.

The exact configuration should be based on the application's requirements.

---

# 20. Input Validation

Input validation ensures incoming data satisfies expected constraints before processing.

### Example

```java
public record CreateUserRequest(

    @NotBlank
    @Size(max = 100)
    String username,

    @Email
    String email

) {}
```

Controller:

```java
@PostMapping
public ResponseEntity<?> create(
        @Valid @RequestBody CreateUserRequest request) {

    ...
}
```

### Important

Input validation does **not** replace parameterized queries.

For example:

```text
Input Validation
       +
Parameterized Queries
       +
Authorization
       +
Output Encoding
```

provide stronger defense in depth.

---

# 21. Principle of Least Privilege

Every component should have only the permissions it actually needs.

For example, an application that only reads customer data should not have database permissions to:

```text
DROP DATABASE
DELETE *
CREATE USER
```

This applies to:

* Database users.
* AWS IAM roles.
* Kubernetes service accounts.
* Application roles.
* API permissions.

### Benefit

If an application is compromised, least privilege limits the potential damage.

---

# 22. Dependency Vulnerabilities

Java applications depend heavily on third-party libraries.

A vulnerable dependency can introduce a security vulnerability even when application code itself appears correct.

### Practices

* Keep dependencies patched.
* Monitor CVEs.
* Use dependency scanning.
* Remove unused dependencies.
* Avoid untrusted libraries.
* Establish a process for critical security upgrades.

Security scanning should be part of CI/CD.

---

# 23. How Would You Secure a Spring Boot REST API?

A strong interview answer:

> "I would start with HTTPS and Spring Security. I'd authenticate requests using an appropriate mechanism such as OAuth2/OIDC or securely managed tokens. I'd enforce authorization at both endpoint and business-resource levels. I'd validate input, use DTOs, parameterized database queries, and avoid unsafe deserialization. I'd configure CSRF according to the authentication architecture, restrict CORS, protect secrets, avoid sensitive logging, configure security headers, apply rate limiting where appropriate, and keep dependencies patched. Finally, I'd test the application against OWASP risks."

### Typical Request Flow

```text
Client
   |
   | HTTPS
   v
API Gateway / Load Balancer
   |
   v
Spring Security
   |
   +---- Authentication
   |
   +---- Authorization
   |
   v
Controller
   |
   +---- Input Validation
   |
   v
Service
   |
   v
Repository
   |
   +---- Parameterized Query
   |
   v
Database
```

---

# 24. What If You Discover a Security Vulnerability in Production?

A strong senior-level answer:

> "First, I'd assess the severity and exploitability and determine whether sensitive data or systems are exposed. I'd contain the vulnerability if necessary, for example by disabling the affected functionality or applying a configuration-level mitigation. Then I'd patch the root cause, test the fix, deploy it through the appropriate emergency process, and investigate logs for potential exploitation. Finally, I'd document the incident and add automated tests or security controls to prevent regression."

### Security Incident Flow

```text
Detect
  ↓
Assess Severity
  ↓
Contain
  ↓
Investigate
  ↓
Fix / Patch
  ↓
Test
  ↓
Deploy
  ↓
Monitor
  ↓
Prevent Regression
```

---

# 25. OWASP → Java/Spring Mapping

| OWASP / Security Risk       | Java/Spring Mitigation                                |
| --------------------------- | ----------------------------------------------------- |
| Broken Access Control       | Spring Security, `@PreAuthorize`, ownership checks    |
| Cryptographic Failures      | TLS, strong password hashing, key management          |
| Injection                   | Prepared statements, JPA parameters, validation       |
| Insecure Design             | Threat modeling, least privilege, secure architecture |
| Security Misconfiguration   | Secure configuration, headers, restricted endpoints   |
| Vulnerable Components       | Dependency scanning, patching                         |
| Authentication Failures     | Spring Security, OAuth2/OIDC, secure sessions         |
| Data Integrity Failures     | Signed artifacts/tokens, integrity validation         |
| Logging/Monitoring Failures | Audit logs, security monitoring, alerting             |
| SSRF                        | URL allowlists, network restrictions, validation      |
| XSS                         | Output encoding, safe templates, CSP                  |
| CSRF                        | CSRF tokens / appropriate stateless API architecture  |
| Insecure Deserialization    | Avoid Java serialization, controlled DTO/JSON mapping |
| Path Traversal              | Normalize and validate filesystem paths               |
| Command Injection           | Avoid shell execution, allowlist inputs               |

---

# 26. Security Interview Cheat Sheet

When asked:

**"How do you write secure Java code?"**

Remember these 10 points:

1. **Validate input** — never trust user-controlled data.
2. **Prevent injection** — use parameterized SQL and safe APIs.
3. **Authenticate securely** — Spring Security/OAuth2/OIDC.
4. **Authorize every protected operation** — authentication is not authorization.
5. **Protect against CSRF** — based on the authentication architecture.
6. **Avoid insecure deserialization** — prefer controlled DTO/JSON mapping.
7. **Protect sensitive data** — TLS, password hashing, secure secret storage, no sensitive logs.
8. **Apply least privilege** — application, database, cloud, and API permissions.
9. **Secure configuration and dependencies** — patch vulnerabilities and disable unnecessary functionality.
10. **Monitor and test** — security tests, dependency scanning, logging, and incident response.

---

# 27. Senior-Level Security Answer

A strong closing answer for a technical interview:

> "I don't treat OWASP vulnerabilities as isolated coding issues. I look at security across the entire request lifecycle—from authentication and authorization, to input validation, business logic, persistence, serialization, infrastructure, logging, and deployment. The goal is defense in depth, so that even if one control fails, other controls limit the impact."

---

# Quick Mental Model

```text
                 SECURE JAVA APPLICATION
                          |
        +-----------------+------------------+
        |                 |                  |
 Authentication      Authorization       Input
        |                 |               Validation
        |                 |                  |
        +-----------------+------------------+
                          |
                    Business Logic
                          |
        +-----------------+------------------+
        |                 |                  |
    Injection       Deserialization      Access Control
        |                 |                  |
        +-----------------+------------------+
                          |
                       Database
                          |
        +-----------------+------------------+
        |                 |                  |
      Secrets          Logging          Encryption/TLS
                          |
                     Monitoring
                          |
                    CI/CD Security
                          |
                 Dependency Scanning
```

## One-Line Principles to Remember

| Topic             | One-line answer                                                                        |
| ----------------- | -------------------------------------------------------------------------------------- |
| SQL Injection     | **Use parameterized queries; never concatenate untrusted input into SQL.**             |
| XSS               | **Encode untrusted output and avoid rendering raw HTML.**                              |
| CSRF              | **Protect state-changing cookie-authenticated requests with CSRF controls.**           |
| Authentication    | **Verify who the user is.**                                                            |
| Authorization     | **Verify what the user is allowed to do.**                                             |
| IDOR              | **Don't trust object IDs; verify resource ownership/permissions.**                     |
| Passwords         | **Hash with a password-specific algorithm; don't encrypt or store plaintext.**         |
| JWT               | **Validate signature, algorithm, expiration, issuer, and audience where applicable.**  |
| Deserialization   | **Avoid Java native deserialization of untrusted data.**                               |
| Path Traversal    | **Normalize and verify the resolved path stays inside the allowed directory.**         |
| Command Injection | **Avoid shell commands and strictly control arguments when execution is unavoidable.** |
| Secrets           | **Never hardcode or log credentials.**                                                 |
| Least Privilege   | **Give each component only the permissions it needs.**                                 |
| Dependencies      | **Continuously scan and patch vulnerable libraries.**                                  |
| OWASP             | **Use OWASP as a security checklist, but apply defense in depth across the system.**   |

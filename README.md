# ThessaCodes | Java Coding & Interview Review & Practice

A hands-on Java repository for **coding practice, technical interview preparation, and continuous review of Java and software engineering concepts**.

This project is intentionally built as a practical engineering playground: concepts are implemented in code, reviewed through examples, and connected to the kinds of questions and design discussions commonly encountered in technical interviews.

> **Learn it → Code it → Explain it → Apply it**

---

## 🎯 Purpose

The purpose of this project is to provide a single place for my **Java coding practice and technical interview review**.

It is used to:

- Practice Java coding problems and algorithms.
- Strengthen Java fundamentals.
- Review Java language features and version differences.
- Practice Object-Oriented Programming.
- Review SOLID and other software design principles.
- Implement and compare design patterns.
- Practice database and transaction concepts.
- Review security concepts.
- Explore mobile architecture concepts.
- Build examples that can be discussed during technical interviews.
- Turn interview questions into hands-on implementations.
- Maintain a growing personal Java engineering reference.

This is not intended to be a production application. It is a **coding laboratory and interview reviewer**.

---

## 🧠 Interview Preparation Approach

Each topic is approached from four levels:

```text
┌──────────────────────┐
│  1. UNDERSTAND       │
│  What is it?         │
└──────────┬───────────┘
           ↓
┌──────────────────────┐
│  2. IMPLEMENT        │
│  Can I code it?      │
└──────────┬───────────┘
           ↓
┌──────────────────────┐
│  3. EXPLAIN          │
│  Can I explain it?   │
└──────────┬───────────┘
           ↓
┌──────────────────────┐
│  4. APPLY            │
│  When would I use it?│
└──────────────────────┘
```

For interview preparation, knowing a definition is not enough.

For each important concept, the goal is to be able to answer:

```text
What is it?
Why do we need it?
How does it work?
How would I implement it?
When would I use it?
When would I NOT use it?
What are the alternatives?
What are the trade-offs?
```

---

# 📚 Topics Covered

## 1. Java Coding & Algorithms

The `algo` package contains coding exercises and small Java implementations for interview practice.

Examples include:

- String manipulation
- Palindrome problems
- String reversal
- Character processing
- Vowel detection
- Collection manipulation
- Basic algorithmic problems

The goal is to improve:

- Problem decomposition
- Java syntax fluency
- Collections usage
- Time and space complexity awareness
- Clean and readable implementation

---

## 2. Java Language & Version Review

The `javadiff` package contains examples for reviewing Java language evolution.

Current topics include Java 8 features such as:

- Lambda expressions
- Functional interfaces
- Method references
- `Predicate`
- Effectively final variables
- Stream API
- Stream creation
- Lazy evaluation

Java version review also covers major releases and their important features:

| Version | Key Areas |
|---|---|
| Java 8 | Lambda, Functional Interfaces, Streams, Optional, `java.time` |
| Java 11 | HTTP Client, String APIs, JFR |
| Java 17 | Records, Sealed Classes, Pattern Matching |
| Java 21 | Virtual Threads, Pattern Matching, Sequenced Collections |
| Java 25 | Newer language, JVM, and library capabilities |
| Java 26 | Continued Java language and JVM evolution |

The focus is on understanding both **the feature and the engineering problem it solves**.

---

# 🧱 3. Object-Oriented Programming

The `design/oop` package is used to review the foundations of object-oriented design:

- Encapsulation
- Abstraction
- Inheritance
- Polymorphism
- Composition
- Coupling
- Cohesion

Typical interview questions explored through this section include:

```text
Inheritance vs Composition
Interface vs Abstract Class
Overloading vs Overriding
Encapsulation vs Abstraction
Composition vs Aggregation
```

---

# 📐 4. Design Principles

The `design/principles` package contains examples and notes for:

- SOLID
- DRY
- KISS
- YAGNI

The objective is to move beyond memorizing the acronym and understand how the principles influence real design decisions.

Example:

```text
High Cohesion
      +
Loose Coupling
      ↓
Maintainable Design
      ↓
Better Testability
      ↓
Easier Change
```

---

# 🧩 5. Design Patterns

The `design/patterns` package contains implementation examples for common software design patterns.

### GoF Creational

- Abstract Factory
- Builder
- Factory Method
- Prototype
- Singleton

### GoF Structural

- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy

### GoF Behavioral

- Chain of Responsibility
- Command
- Interpreter
- Iterator
- Mediator
- Memento
- Observer
- State
- Strategy
- Template Method
- Visitor

### Dependency Injection

- Dependency Injection
- Constructor Injection

### Distributed Systems

- Bulkhead
- Circuit Breaker
- CQRS
- Event Sourcing
- Idempotency
- Outbox
- Rate Limiter
- Retry
- Saga
- Timeout

These patterns are especially useful when moving from **Java coding interviews into senior/lead-level system design discussions**.

---

# 🗄️ 6. Database & Transaction Concepts

The `design/database` package is used to review database concepts from both application-development and system-design perspectives.

### ACID

- Atomicity
- Consistency
- Isolation
- Durability

### Data Modeling

- Entity Relationship Modeling
- Normalization
- Denormalization
- Star Schema

### Transactions

- Optimistic Locking
- Pessimistic Locking
- Saga
- Unit of Work

### Integration

- Database per Service
- Shared Database
- Change Data Capture
- Event Sourcing

### Performance

- Indexing
- Caching
- Read Replicas
- Partitioning

### Scalability

- Partitioning
- Sharding
- Replication
- Read Replicas

Interview discussions should connect these concepts to requirements:

```text
Access Pattern
      ↓
Consistency Requirement
      ↓
Transaction Requirement
      ↓
Performance Requirement
      ↓
Scalability Requirement
      ↓
Database Design
```

---

# 📱 7. Mobile Architecture

The `design/mobile` package contains mobile architecture and engineering concepts.

### Architecture

- MVC
- MVP
- MVVM
- MVI
- Clean Architecture

### Data

- Repository
- Data Source
- Local Cache
- Offline First

### Networking

- API Client
- Retry
- Cache
- Offline Synchronization

### UI

- Accessibility
- Navigation
- Presenter
- Responsive Design
- State Management
- Coordinator
- Observer

---

# 🔐 8. Security

The `security` package contains security concepts relevant to Java backend and technical interviews.

Topics include:

- Secure coding
- SQL Injection
- XSS
- CSRF
- Insecure Deserialization
- Authentication
- Authorization
- IDOR
- Command Injection
- Path Traversal
- JWT
- Sensitive Data Exposure
- Security Misconfiguration
- CORS
- Security Headers
- Password Hashing

The `summary.md` file provides a compact review of these concepts.

---

# 📁 Project Structure

```text
demo-core/
│
├── README.md
├── pom.xml
├── mvnw
├── mvnw.cmd
│
└── src/
    ├── main/
    │   └── java/com/java/core/
    │       │
    │       ├── algo/
    │       │   ├── CollectVowelPosition.java
    │       │   ├── Palindrome.java
    │       │   ├── ReverseString.java
    │       │   └── Main.java
    │       │
    │       ├── design/
    │       │   ├── oop/
    │       │   ├── principles/
    │       │   ├── patterns/
    │       │   │   ├── gof_creational/
    │       │   │   ├── gof_structural/
    │       │   │   ├── gof_behavioral/
    │       │   │   ├── distributed/
    │       │   │   └── dependency_injection/
    │       │   │
    │       │   ├── database/
    │       │   │   ├── acid/
    │       │   │   ├── data_modeling/
    │       │   │   ├── integration/
    │       │   │   ├── performance/
    │       │   │   ├── scalability/
    │       │   │   └── transaction/
    │       │   │
    │       │   └── mobile/
    │       │       ├── architecture/
    │       │       ├── data/
    │       │       ├── networking/
    │       │       └── ui/
    │       │
    │       ├── javadiff/
    │       │   └── java8/
    │       │       ├── lambda/
    │       │       └── streams/
    │       │
    │       └── security/
    │           ├── Security.java
    │           └── summary.md
    │
    └── test/
        └── java/com/java/demo_core/
            ├── algo/
            └── DemoCoreApplicationTests.java
```

---

# 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java | Primary programming language |
| Java 17 | Current project baseline |
| Spring Boot | Application framework |
| Maven | Build and dependency management |
| JUnit | Testing |
| IntelliJ IDEA | Recommended IDE |
| Git | Source control |

---

# 🚀 Getting Started

## Prerequisites

Install:

- Java 17+
- Git
- IntelliJ IDEA or another Java IDE

Verify Java:

```bash
java -version
```

---

## Build

Using the Maven Wrapper:

### macOS / Linux

```bash
./mvnw clean compile
```

### Windows

```cmd
mvnw.cmd clean compile
```

---

## Run Tests

```bash
./mvnw test
```

Run a specific test:

```bash
./mvnw -Dtest=PalindromeTest test
```

---

# 🧪 Coding Practice Workflow

For coding problems, the preferred workflow is:

```text
Understand the Problem
        ↓
Clarify Inputs / Outputs
        ↓
Identify Constraints
        ↓
Choose Data Structure
        ↓
Develop Algorithm
        ↓
Consider Edge Cases
        ↓
Implement
        ↓
Test
        ↓
Analyze Complexity
        ↓
Improve
```

For every algorithm, try to identify:

### Time Complexity

```text
O(1)
O(log n)
O(n)
O(n log n)
O(n²)
```

### Space Complexity

```text
O(1)
O(n)
O(n²)
```

The goal is not always to achieve the theoretically fastest solution, but to understand the trade-off between:

- Readability
- Complexity
- Memory
- Maintainability
- Implementation risk

---

# 🎤 Technical Interview Review Workflow

For each interview topic, practice answering in this order:

### Level 1 — Definition

> What is it?

### Level 2 — Purpose

> Why do we use it?

### Level 3 — Implementation

> How would you implement it in Java?

### Level 4 — Practical Application

> When would you use it in a real system?

### Level 5 — Trade-offs

> What are the advantages, disadvantages, and alternatives?

### Level 6 — Architecture

> How does this concept fit into a larger application or distributed system?

Example:

```text
Circuit Breaker
      ↓
Java implementation
      ↓
Spring application
      ↓
Microservice
      ↓
Downstream failure
      ↓
Resilience strategy
      ↓
System architecture
```

---

# 🔄 From Coding to System Design

This repository is intended to grow from basic coding exercises into broader engineering discussions.

```text
Java Fundamentals
        ↓
Coding & Algorithms
        ↓
OOP
        ↓
Design Principles
        ↓
Design Patterns
        ↓
Database Design
        ↓
Security
        ↓
Concurrency
        ↓
Spring / Backend
        ↓
Microservices
        ↓
Distributed Systems
        ↓
System Design
```

This progression reflects the way technical interviews often move from:

**"Can you code?"**

to:

**"Can you design?"**

and eventually:

**"Can you make good engineering decisions?"**

---

# 📌 Future Topics

Planned additions include:

### Java

- Collections deep dive
- Generics
- Exception handling
- Concurrency
- Executors
- `CompletableFuture`
- Virtual Threads
- JVM internals
- Garbage Collection
- Java Memory Model

### Spring

- Spring Core
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate
- REST API design

### Distributed Systems

- Kafka
- Redis
- Event-driven architecture
- Microservices
- Resilience patterns
- Distributed transactions
- Observability

### DevOps / Cloud

- Docker
- Kubernetes
- CI/CD
- AWS
- GCP

### Testing

- JUnit
- Mockito
- Integration Testing
- Testcontainers
- Cucumber
- Karate
- Performance Testing

### System Design

- API design
- Scalability
- High availability
- Caching
- Messaging
- Database scaling
- Rate limiting
- Load balancing
- Fault tolerance

---

# 📖 Recommended Study Principle

The repository should remain **hands-on**.

For every important topic:

```text
📖 Read
   ↓
💡 Understand
   ↓
💻 Implement
   ↓
🧪 Test
   ↓
🗣️ Explain
   ↓
🏗️ Apply to System Design
```

A concept is considered well reviewed when I can:

1. Explain it clearly.
2. Implement a basic example.
3. Identify an appropriate use case.
4. Explain its trade-offs.
5. Compare it with alternatives.
6. Apply it to a real engineering scenario.

---

# 📝 Project Philosophy

This repository is my **Java coding and technical interview practice laboratory**.

It is intentionally not a collection of copied definitions or production-ready frameworks.

The focus is on building the ability to move between:

```text
Code
 ↕
Concept
 ↕
Design
 ↕
Architecture
 ↕
Engineering Decision
```

The ultimate goal is:

> **Be able to write the code, explain the code, defend the design, and discuss the trade-offs.**

---


---

# 📚 References

This project uses external learning resources as part of my **ongoing Java coding practice, technical interview preparation, and continuous review of the Java platform**.

The references are used to:

- Review Java fundamentals and core concepts.
- Reinforce concepts through hands-on implementation.
- Keep my Java knowledge up to date across **Java 8 and newer Java releases**.
- Review language features, APIs, and improvements introduced after Java 8.
- Understand how Java has evolved across major releases.
- Support preparation for technical interviews where knowledge of both legacy and modern Java is important.
- Translate learning material into practical code and interview-ready explanations.

## ☕ Keeping Current with Java 8+

A key objective of this repository is to maintain and continuously update my knowledge of Java from **Java 8 onward**.

Java 8 was a major milestone in modern Java, introducing features such as:

```text
Lambda Expressions
Functional Interfaces
Stream API
Optional
Method References
Default Methods
java.time
```

The subsequent Java releases introduced additional language, API, JVM, and concurrency improvements.

This repository therefore uses learning references to help maintain awareness of Java's evolution:

```text
Java 8
  ↓
Java 11
  ↓
Java 17
  ↓
Java 21
  ↓
Java 25
  ↓
Current / Latest Java
```

The objective is not simply to learn newer syntax. It is to understand **why Java evolved, what problems newer features solve, and when those features should be used in modern software development**.

---

## Udemy

### OCP 11 Java Certification — From OCA 8

**Platform:** Udemy  
**Course:** OCP 11 Java Certification — From OCA 8

This course is used as a structured learning and review reference for Java concepts, particularly for strengthening knowledge of the Java platform from **Java 8 through Java 11**.

**Course:** https://www.udemy.com/course/ocp11_from_oca8/

### Lectures Referenced

- **OCP 11 Java Certification — From OCA 8**
  - https://www.udemy.com/course/ocp11_from_oca8/learn/lecture/45477869#overview

> **Reference note:** External courses, videos, documentation, and other learning resources used during development are references for learning and review. The implementations in this repository are independently written as part of my coding and interview practice.

---

## 📌 Reference Philosophy

References are used as a **learning aid**, not as a replacement for hands-on practice.

The preferred learning cycle is:

```text
Reference
    ↓
Understand
    ↓
Implement
    ↓
Experiment
    ↓
Test
    ↓
Explain
    ↓
Apply to Interview / Real-World Scenario
```

This keeps the repository focused on **active learning and practical Java engineering**, rather than simply collecting notes or reproducing course material.

---

# 👩‍💻 Author

**ThessaCodes**

Java • Software Engineering • Architecture • Technical Interview Preparation

---

> This project is intended for personal coding practice, technical interview review, and continuous software engineering learning.

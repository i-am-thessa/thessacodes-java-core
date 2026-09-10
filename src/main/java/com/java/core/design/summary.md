# Design Review Summary

## Design Review Classification

The design review is organized around five major areas:

| Category       | Main Question                                              |
| -------------- | ---------------------------------------------------------- |
| **OOP**        | How do objects and classes work?                           |
| **Principles** | How do I create good object and component designs?         |
| **Patterns**   | What reusable solutions can I apply?                       |
| **Mobile**     | How do I apply good design to mobile systems?              |
| **Database**   | How do I design data, persistence, and access effectively? |

The learning progression is:

```text
OOP
 ↓
High Cohesion + Loose Coupling
 ↓
Design Principles
 ↓
Design Patterns
 ↓
Mobile + Database
```

The goal is to understand **why a design is good**, not simply memorize terminology or patterns.

---

# 1. OOP — The Foundation

### Main question

> **How do objects and classes work?**

Object-Oriented Programming provides the fundamental building blocks for designing software.

## Core Concepts

* Class
* Object
* Encapsulation
* Abstraction
* Inheritance
* Polymorphism
* Composition
* Association
* Aggregation
* Dependency

## Key Design Idea

OOP is not simply about creating classes.

The important question is:

> **How should responsibilities and behavior be organized among objects?**

For every class, consider:

* What responsibility does it have?
* What data does it own?
* What behavior does it provide?
* What other objects does it depend on?
* What should be hidden?
* What should be exposed?
* Should it use inheritance or composition?

---

# 2. Design Principles — The Core

The two most important concepts for evaluating software design are:

## High Cohesion

> **Keep things that belong together together.**

A class or module should have responsibilities that are strongly related to one another.

### Good example

```text
CustomerService
 ├── createCustomer()
 ├── updateCustomer()
 └── getCustomer()
```

These responsibilities are related to customers.

### Poor example

```text
CustomerService
 ├── createCustomer()
 ├── sendEmail()
 ├── generatePDF()
 ├── processPayment()
 └── calculateShipping()
```

The class has unrelated responsibilities and therefore has low cohesion.

### Goal

```text
High Cohesion
     ↓
Related responsibilities stay together
     ↓
Clearer classes/modules
     ↓
Easier maintenance and testing
```

---

# 3. Loose Coupling

> **Minimize unnecessary dependencies between components.**

A component should not know more than it needs to know about another component.

### Tightly coupled

```text
OrderService
     ↓
ConcretePaymentProcessor
     ↓
SpecificBankAPI
```

Changing the bank API may require changes throughout the application.

### Loosely coupled

```text
OrderService
     ↓
PaymentProcessor
     ↓
PaymentProcessor implementation
```

The service depends on an abstraction rather than a specific implementation.

### Goal

```text
Loose Coupling
      ↓
Components can change independently
      ↓
Easier testing
      ↓
Easier maintenance
      ↓
Easier extension
```

---

# 4. Cohesion + Coupling Together

High cohesion and loose coupling should be considered together.

The ideal design generally aims for:

```text
        HIGH COHESION
              +
        LOOSE COUPLING
              ↓
       GOOD SOFTWARE DESIGN
```

### High Cohesion

Ask:

> "Do these responsibilities belong together?"

### Loose Coupling

Ask:

> "How dependent is this component on other components?"

These two questions can be used when reviewing almost any design.

---

# 5. Supporting Design Principles

Once High Cohesion and Loose Coupling are understood, other principles become easier to understand because many of them help achieve these goals.

## SOLID

### Single Responsibility Principle

A class should have one primary responsibility.

**Connection:**

```text
SRP → Higher Cohesion
```

### Open/Closed Principle

Software should be open for extension but closed for unnecessary modification.

**Connection:**

```text
OCP → Controlled change
    → Lower coupling
```

### Liskov Substitution Principle

Subtypes should be usable wherever their base abstraction is expected.

### Interface Segregation Principle

Clients should not be forced to depend on interfaces they do not need.

**Connection:**

```text
ISP → Smaller interfaces
    → Lower coupling
```

### Dependency Inversion Principle

High-level components should depend on abstractions rather than concrete implementations.

**Connection:**

```text
DIP → Dependency on abstractions
    → Lower coupling
```

---

## Other Supporting Principles

* DRY — Don't Repeat Yourself
* KISS — Keep It Simple
* YAGNI — You Aren't Gonna Need It
* Separation of Concerns
* Composition over Inheritance
* Program to an Interface
* Law of Demeter

These should be viewed as **tools that help maintain good cohesion and loose coupling**, rather than isolated rules to memorize.

---

# 6. Design Patterns

### Main question

> **What reusable solutions can I apply to recurring design problems?**

Patterns should come **after OOP and design principles**.

The goal is not:

> "I need to use a pattern."

Instead:

> "I have a recurring design problem. Is there an established pattern that helps solve it?"

## Creational

* Factory Method
* Abstract Factory
* Builder
* Prototype
* Singleton

## Structural

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Proxy

## Behavioral

* Chain of Responsibility
* Command
* Iterator
* Mediator
* Observer
* State
* Strategy
* Template Method
* Visitor

### Pattern Review

For every pattern, understand:

```text
Problem
   ↓
Why the obvious solution is insufficient
   ↓
Pattern
   ↓
Structure
   ↓
Benefits
   ↓
Trade-offs
   ↓
When NOT to use it
```

Patterns should ultimately be evaluated using the two core design principles:

```text
Does this pattern improve cohesion?

Does this pattern reduce unnecessary coupling?
```

If not, the pattern may be unnecessary or may be the wrong abstraction.

---

# 7. Mobile

### Main question

> **How do I apply good software design to mobile systems?**

Mobile development introduces additional constraints.

## Key Areas

* Application lifecycle
* Network reliability
* Offline-first design
* Local storage
* Caching
* Synchronization
* Authentication
* Secure storage
* Push notifications
* Background processing
* Battery consumption
* Memory management
* Performance
* UI state management
* Error handling

## Architecture

Review:

* MVC
* MVP
* MVVM
* Clean Architecture
* Repository Pattern
* Dependency Injection
* Unidirectional Data Flow

### Design Questions

For every mobile architecture, ask:

* Is each component cohesive?
* Are components loosely coupled?
* Can the UI be tested independently?
* Can the data source change without affecting the UI?
* Can the application operate when the network is unavailable?
* How is state managed?
* How are failures handled?

---

# 8. Database

### Main question

> **How do I store, retrieve, and manage data effectively?**

Database design should consider:

* Data modeling
* Relationships
* Consistency
* Transactions
* Performance
* Scalability
* Availability
* Security

## Relational Database

Review:

* Tables
* Primary keys
* Foreign keys
* Relationships
* Normalization
* Indexes
* Constraints
* Transactions
* ACID
* Joins
* Query optimization

## NoSQL

Review:

* Key-value databases
* Document databases
* Wide-column databases
* DynamoDB
* Access-pattern-driven design
* Partition keys
* Sort keys
* Eventual consistency
* Denormalization

## Database Architecture

Understand:

* Connection pooling
* Read replicas
* Caching
* Database per service
* CQRS
* Event-driven data synchronization
* Sharding
* Polyglot persistence

### Design Questions

Ask:

> Is the data model appropriate for the access patterns?

> Is the database creating unnecessary coupling between components?

> Does the persistence layer have a clear responsibility?

> Can the database implementation change without affecting the business logic?

---

# 9. How Everything Connects

The overall mental model is:

```text
                         OOP
                          │
                          ▼
              Objects & Responsibilities
                          │
                          ▼
              ┌───────────────────────┐
              │                       │
              ▼                       ▼
        HIGH COHESION          LOOSE COUPLING
              │                       │
              └───────────┬───────────┘
                          ▼
                DESIGN PRINCIPLES
                          │
                          ▼
                 DESIGN PATTERNS
                          │
              ┌───────────┴───────────┐
              ▼                       ▼
           MOBILE                  DATABASE
```

Each layer builds upon the previous one.

### OOP

Defines the fundamental building blocks.

### High Cohesion

Determines whether responsibilities are grouped appropriately.

### Loose Coupling

Determines how independently components can change.

### Design Principles

Provide additional rules for maintaining good design.

### Design Patterns

Provide reusable solutions to recurring problems.

### Mobile

Applies these concepts under mobile-specific constraints.

### Database

Applies these concepts to data persistence and access.

---

# 10. Design Review Mental Model

When reviewing a design, start with the following questions:

### 1. What are the objects?

```text
What are the important entities?
What responsibilities do they have?
```

### 2. Is the design cohesive?

```text
Are related responsibilities together?
Are unrelated responsibilities separated?
```

### 3. Is the design loosely coupled?

```text
Can components change independently?
Are dependencies minimized?
Are abstractions used appropriately?
```

### 4. Which principles apply?

```text
Does SRP help?
Does DIP help?
Does ISP help?
Would composition be better than inheritance?
```

### 5. Is a pattern actually necessary?

```text
Is there a recurring problem?
Does a known pattern solve it?
Does the pattern improve the design?
```

### 6. What are the system constraints?

```text
Mobile?
Database?
Network?
Performance?
Scalability?
Security?
Availability?
```

### 7. What are the trade-offs?

```text
What do we gain?
What complexity do we introduce?
What are the alternatives?
```

---

# 11. Final Goal

The ultimate goal of the design review is to move from:

> **"I know the definition."**

to:

> **"I understand the problem, can evaluate the design, can explain the trade-offs, and can implement the solution."**

The most important mental model is:

```text
             OOP
              ↓
     Define responsibilities
              ↓
       HIGH COHESION
              +
       LOOSE COUPLING
              ↓
      Apply principles
              ↓
   Select appropriate patterns
              ↓
 Apply to Mobile / Database
              ↓
      Evaluate trade-offs
              ↓
        Final Design
```

The objective is therefore **not to memorize OOP concepts, SOLID principles, or design patterns individually**.

The objective is to develop the ability to answer:

> **"Why is this design better?"**

and:

> **"What would happen if this requirement changes?"**

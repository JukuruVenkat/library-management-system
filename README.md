# 📚 Enterprise Library Management System (LLD)

A robust, production-ready Library Management System designed in Java. This project demonstrates advanced Object-Oriented Programming (OOP) concepts, SOLID principles, concurrent programming practices, and classic GoF Design Patterns.

## 🚀 Key Technical Features

* **Thread-Safety & Concurrency:** Designed for multithreaded environments.
    * Uses `ConcurrentHashMap` for branch and patron storage.
    * Uses `CopyOnWriteArrayList` to prevent `ConcurrentModificationException` in borrowing histories and observer lists.
    * Uses `volatile` boolean flags with `ReentrantLock` (`tryLock()`) on the `Book` entity to prevent checkout race conditions and double-booking.
* **Design Patterns Implemented:**
    * **Observer Pattern:** `Reservation` acts as the Subject, pushing real-time context updates to the `NotificationService`.
    * **Strategy Pattern:** Decouples recommendation algorithms (`HistoryBasedRecommendation`, `GenreBasedRecommendation`).
    * **Factory Pattern:** `RecommendationFactory` centralizes the instantiation of the correct `RecommendationStrategy` at runtime.
* **SOLID Architecture:** Strictly adheres to Single Responsibility, Open/Closed, and Dependency Inversion (high-level services depend on interfaces like `LibraryService` and `LendingService`, not implementations).
* **Immutability:** Encapsulated collections return `List.copyOf()` to prevent external mutation of domain state.

## 📊 Class Architecture

```mermaid
classDiagram
    %% Interfaces
    class LibraryService { <<interface>> }
    class LendingService { <<interface>> }
    class Observer { <<interface>> }
    class Subject { <<interface>> }
    class RecommendationStrategy { <<interface>> }

    %% Domain Models
    class Book {
      -String isbn
      -volatile boolean available
      -Lock lock
      +tryCheckout() boolean
      +markReturned()
    }
    class Patron {
      -String id
      -List~Loan~ borrowingHistory
      +addLoan(Loan)
    }
    class Branch {
      -String id
      -Map~String, Book~ inventory
      +addBook(Book)
    }
    class Loan {
      -LocalDate checkoutDate
      +returnBook()
    }
    class Reservation {
      -List~Observer~ observers
      +notifyObservers()
    }

    %% Relationships
    LibraryService <|.. LibraryServiceImpl
    LendingService <|.. LendingServiceImpl
    LendingServiceImpl --> Book
    LendingServiceImpl --> Loan
    LendingServiceImpl --> Patron
    
    LibraryServiceImpl --> Branch
    LibraryServiceImpl --> Patron

    Subject <|.. Reservation
    Observer <|.. NotificationService
    Reservation o-- Observer : notifies
    
    RecommendationStrategy <|.. HistoryBasedRecommendation
    RecommendationStrategy <|.. GenreBasedRecommendation
    RecommendationFactory --> RecommendationStrategy : creates
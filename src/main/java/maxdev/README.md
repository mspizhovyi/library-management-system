

# 📘 Part 3: Dependency Inversion — Refactoring & Abstraction

## ✅ Task Checklist

✔ 1. Create a `Book` interface with:
- `toString()`
- `setIsAvailable(boolean isAvailable)`
- `getIsAvailable()`
- `getTitle()`

✔ 2. Make the `PaperBook` class implement the `Book` interface

✔ 3. Refactor `Library` and `Member` so they depend on the `Book` interface instead of `PaperBook`

✔ 4. Validate all changes to ensure the application still functions correctly

✔ 5. Update tests in `AllTests.java` to reflect the new abstraction-based design

✔ 6. Add any new required tests and include them in the test suite


# 📄 Submission Answers

## 1. Why did you introduce the Book interface, and how does this relate to the Dependency Inversion Principle?

I introduced the `Book` interface to remove the direct dependency between high-level classes (`Member`, `Library`) and the concrete class `PaperBook`.  
This follows the **Dependency Inversion Principle (DIP)** because high-level modules should depend on abstractions, not specific implementations.  
By doing this, the system becomes more modular, testable, and easier to extend.


## 2. How does this design improve the flexibility of the system?

The system becomes more flexible because `Member` and `Library` now work with any object that implements `Book`.  
This allows us to add new types of books — like `EBook`, `AudioBook`, or future formats — without modifying existing code.  
All new book types simply implement the same interface, keeping the system consistent and extendable.


## 3. How do your changes support the Open/Closed Principle?

The refactored design supports the **Open/Closed Principle** because the system is open for extension but closed for modification.  
To add new book behaviors, we create new classes implementing `Book` rather than modifying `Member` or `Library`.  
This prevents code breakage and reduces the risk of introducing bugs.


## 4. What did you learn about the benefits of using abstractions and interfaces in this example?

I learned that abstractions help reduce coupling, improve maintainability, and make the entire architecture more scalable.  
Interfaces allow the system to focus on *what* needs to be done rather than *how* it is implemented.  
This leads to cleaner code, easier testing, and a structure that can grow without constant refactoring.
m into the test suite (add their class names to the AllTests.java)
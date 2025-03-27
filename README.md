# Java Essentials: Exceptions, Collections, and Lambda Expressions

## Introduction
This document provides an overview of three essential concepts in Java: **Exceptions**, **Collections**, and **Lambda Expressions**. Understanding these topics is crucial for writing robust, efficient, and modern Java applications. As I complete the course, I will provide updates on concurrency and mutlithreading, as well as streams and the executive framework. Feel free to suggest any additions on these topics.

- **Exceptions** help in handling runtime errors and improving application stability.
- **Collections** offer powerful data structures for managing and manipulating data.
- **Lambda Expressions** enable functional programming features for concise and readable code.

Let's dive into each topic in detail!

## Exceptions
Exceptions in Java are events that disrupt the normal flow of a program. Java provides a robust exception-handling mechanism using `try`, `catch`, `finally`, and `throw`.

### Common Exception Types:
- **Checked Exceptions**: Must be handled at compile time (e.g., `IOException`, `SQLException`).
- **Unchecked Exceptions**: Occur at runtime (e.g., `NullPointerException`, `ArrayIndexOutOfBoundsException`).
- **Errors**: Serious issues typically not recoverable (e.g., `OutOfMemoryError`).

### Handling Exceptions:
```java
try {
    int result = 10 / 0; // ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
} finally {
    System.out.println("Execution completed.");
}
```

## Collections Framework
Java Collections Framework (JCF) provides data structures and algorithms to manage and manipulate groups of objects efficiently.
I will expound more on this once I begin covering in-depth concepts on java algorithms.

### Key Interfaces & Implementations:
- **List** (Ordered, allows duplicates) → `ArrayList`, `LinkedList`
- **Set** (No duplicates) → `HashSet`, `TreeSet`
- **Queue** (FIFO) → `PriorityQueue`, `LinkedList`
- **Map** (Key-Value pairs) → `HashMap`, `TreeMap`

### Example Usage:
```java
import java.util.*;

List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
System.out.println(list);

Set<Integer> set = new HashSet<>();
set.add(10);
set.add(20);
System.out.println(set);

Map<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");
System.out.println(map);
```

## Lambda Expressions
Lambda expressions provide a concise way to implement functional interfaces (interfaces with a single abstract method) in Java.

### Syntax:
```java
(parameters) -> expression
(parameters) -> { statements }
```

### Example Usage:
```java
import java.util.*;

List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(name -> System.out.println(name));

// Using Lambda for Sorting
Collections.sort(names, (a, b) -> a.compareTo(b));
System.out.println(names);
```

Lambda expressions are widely used in Java Streams, multithreading, and functional programming patterns.

---
### 🚀 Summary
- **Exceptions** handle runtime errors gracefully.
- **Collections** provide efficient data storage and manipulation.
- **Lambda Expressions** offer concise and readable functional-style code.


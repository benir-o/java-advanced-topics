# Java Core Concepts: Exceptions, Collections, Lambda Expressions & Streams

This repository highlights key features of **Exceptions, Collections, Lambda Expressions, and Streams** in Java, which are essential for writing efficient and maintainable code.

---

## 🚀 1. Exceptions in Java
Exceptions help handle runtime errors gracefully, improving application reliability.

### **Types of Exceptions**
- **Checked Exceptions** (Handled at compile-time, e.g., `IOException`, `SQLException`).
- **Unchecked Exceptions** (Runtime errors, e.g., `NullPointerException`, `ArrayIndexOutOfBoundsException`).
- **Errors** (Serious system-level issues, e.g., `OutOfMemoryError`).

### **Handling Exceptions**
```java
try {
    int result = 10 / 0; // Throws ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
} finally {
    System.out.println("Execution completed.");
}
```

### **Custom Exceptions**
```java
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
```

---

## 📚 2. Collections in Java
The **Java Collections Framework** provides data structures for efficient data management.

### **Types of Collections**
- **List** (Ordered, allows duplicates: `ArrayList`, `LinkedList`)
- **Set** (Unique elements: `HashSet`, `TreeSet`, `LinkedHashSet`)
- **Queue** (FIFO ordering: `PriorityQueue`, `Deque`)
- **Map** (Key-value pairs: `HashMap`, `TreeMap`, `LinkedHashMap`)

### **Example Usage**
```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
names.add("Alice"); // Allows duplicates
System.out.println(names);
```

```java
Set<String> uniqueNames = new HashSet<>(names);
System.out.println(uniqueNames); // Removes duplicates
```

---

## 🔥 3. Lambda Expressions
Lambda expressions provide a concise way to implement functional interfaces.

### **Syntax:**
```java
(parameters) -> expression
(parameters) -> { statements; }
```

### **Example Usage**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(name -> System.out.println(name));
```

```java
Comparator<Integer> comparator = (a, b) -> a - b;
Collections.sort(Arrays.asList(3, 1, 2), comparator);
```

---

## 🌊 4. Streams API
Streams process collections efficiently using functional programming.

### **Key Features**
✅ Declarative Processing  
✅ Lazy Evaluation  
✅ Functional Programming Support  
✅ Parallel Processing  

### **Example Usage**
```java
List<String> names = List.of("Alice", "Bob", "Charlie");
names.stream()
    .filter(name -> name.startsWith("A"))
    .map(String::toUpperCase)
    .forEach(System.out::println);
```

### **Parallel Processing**
```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);
numbers.parallelStream()
    .map(n -> n * 2)
    .forEach(System.out::println); // Order not guaranteed
```

---

## 🛠️ Summary
| Feature         | Description |
|----------------|-------------|
| **Exceptions**  | Handle runtime errors gracefully |
| **Collections** | Data structures for efficient storage and manipulation |
| **Lambda Expressions** | Functional programming, cleaner syntax |
| **Streams API** | Process collections with declarative operations |

---

## 📖 Learn More
- [Official Java Documentation](https://docs.oracle.com/javase/8/docs/)
- [Baeldung Java Guide](https://www.baeldung.com/)

### Author- Benir Omenda


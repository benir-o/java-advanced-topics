# Java Streams API

The **Java Streams API** (introduced in Java 8) provides a powerful way to process collections of data in a functional and declarative manner. It enables operations such as filtering, mapping, and reducing in a concise and efficient way.

---

## 🚀 Features of Java Streams API

### 1️⃣ **Declarative Processing**
- Eliminates the need for explicit loops.
- Allows a more readable and expressive approach.

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
names.stream()
    .filter(name -> name.startsWith("A"))
    .forEach(System.out::println); // Output: Alice
```

### 2️⃣ **Lazy Evaluation**
- Intermediate operations (like `map()`, `filter()`) are **lazy**, meaning they execute only when a terminal operation is called.

```java
Stream<String> stream = Stream.of("A", "B", "C")
    .peek(System.out::println) // No output yet!
    .map(String::toLowerCase);

stream.forEach(System.out::println); // Now execution starts
```

### 3️⃣ **Functional Programming Support**
- Encourages the use of lambda expressions and method references for cleaner code.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);
numbers.stream()
    .map(n -> n * 2)
    .forEach(System.out::println); // Output: 2, 4, 6, 8, 10
```

### 4️⃣ **Parallel Processing**
- Supports **parallel execution** for improved performance on large datasets.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);
numbers.parallelStream()
    .map(n -> n * 2)
    .forEach(System.out::println); // Parallel execution, order not guaranteed
```

### 5️⃣ **Intermediate & Terminal Operations**

#### **✅ Intermediate Operations (Lazy)**
- `map(Function)`: Transforms each element.
- `filter(Predicate)`: Selects elements based on a condition.
- `sorted()`: Sorts elements.
- `peek(Consumer)`: Debugging/logging.

#### **🏁 Terminal Operations (Trigger Execution)**
- `forEach(Consumer)`: Iterates over elements.
- `collect(Collector)`: Collects results into lists, sets, etc.
- `reduce(BinaryOperator)`: Reduces elements to a single value.
- `count()`: Returns the number of elements.

```java
long count = Stream.of("apple", "banana", "cherry")
    .filter(fruit -> fruit.startsWith("b"))
    .count();
System.out.println(count); // Output: 1
```

### 6️⃣ **Reduction & Collectors**
- Performs **aggregation** (sum, average, grouping, etc.).

```java
int sum = Stream.of(1, 2, 3, 4, 5)
    .reduce(0, Integer::sum);
System.out.println(sum); // Output: 15
```

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
String result = names.stream()
    .collect(Collectors.joining(", "));
System.out.println(result); // Output: Alice, Bob, Charlie
```

---

## 🛠️ When to Use Streams
✅ When working with collections and need a **concise, functional** approach.  
✅ When needing **parallel processing** for performance benefits.  
✅ When performing **complex data transformations** efficiently.  

⚠️ **Avoid streams when:**
- You need indexed access (prefer lists instead).
- Performance is critical in small collections (traditional loops may be faster).

---

## 📚 Learn More
- [Official Java Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
- [Java 8 Stream API Guide](https://www.baeldung.com)

## Author- Benir Omenda

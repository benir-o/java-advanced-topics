# My summary on Java Functional Interfaces: Consumers, Suppliers, Functions, and Predicates

## Introduction
Throughout this project, you will encounter my practice, skills and applications of functional interfaces in my java projects. Feel free to check my code and bring suggestions!
Java provides a set of built-in **functional interfaces** in the `java.util.function` package to support **functional programming**. These interfaces facilitate passing behavior as arguments, making code more modular and readable. The key functional interfaces are:

- **`Consumer<T>`** – Accepts an argument and performs an action, **no return value**.
- **`Supplier<T>`** – Produces a result **without taking any input**.
- **`Function<T, R>`** – Takes an input and **returns a result**.
- **`Predicate<T>`** – Tests a condition and **returns a boolean**.

---

## `Consumer<T>`: Performing Actions
A `Consumer<T>` represents an operation that **accepts a value but does not return a result**. It is commonly used in operations like logging or modifying objects.

### **Example: Using `Consumer<T>`**
```java
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> printMessage = message -> System.out.println("Message: " + message);
        printMessage.accept("Hello, Java!");
    }
}
```
**Output:**
```
Message: Hello, Java!
```
### **Chaining Consumers with `andThen()`**
```java
Consumer<String> first = s -> System.out.println("First: " + s);
Consumer<String> second = s -> System.out.println("Second: " + s.toUpperCase());
Consumer<String> combined = first.andThen(second);
combined.accept("hello");
```
**Output:**
```
First: hello
Second: HELLO
```

---

## `Supplier<T>`: Generating Values
A `Supplier<T>` provides a value **without taking any input**. It is useful for **lazy initialization, caching, and object creation**.

### **Example: Using `Supplier<T>`**
```java
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Random Value: " + randomValue.get());
    }
}
```
**Output:** *(Example)*
```
Random Value: 0.837461829
```

---

## `Function<T, R>`: Transforming Data
A `Function<T, R>` **accepts an input and returns a result**. It is used for **data transformation, mapping, and computations**.

### **Example: Using `Function<T, R>`**
```java
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> lengthFunction = str -> str.length();
        System.out.println("Length: " + lengthFunction.apply("Hello"));
    }
}
```
**Output:**
```
Length: 5
```
### **Chaining Functions with `andThen()`**
```java
Function<Integer, Integer> doubleIt = x -> x * 2;
Function<Integer, String> toString = x -> "Result: " + x;
Function<Integer, String> pipeline = doubleIt.andThen(toString);
System.out.println(pipeline.apply(5));
```
**Output:**
```
Result: 10
```

---

## `Predicate<T>`: Evaluating Conditions
A `Predicate<T>` **takes an input and returns a boolean**. It is commonly used in **filtering, validation, and


# Chaining Lambda Expressions in Java

## Introduction
Lambda expressions in Java allow functional-style programming by treating functions as first-class citizens. Chaining lambda expressions enables **composing multiple operations sequentially**, improving readability and modularity.

One common way to chain lambda expressions is through methods like **`andThen()`** in functional interfaces such as **`Consumer<T>`** and **`Function<T, R>`**.

## Why Chain Lambdas?
- ✅ **Improves readability** by structuring operations in a sequential manner.
- ✅ **Encapsulates behavior** in reusable lambda functions.
- ✅ **Enhances modularity** by breaking operations into smaller functional units.
- ✅ **Works well with functional interfaces** like `Consumer`, `Function`, and `Predicate`.

---

## Chaining with `Consumer<T>.andThen()`
`Consumer<T>` represents an operation that **takes an argument but does not return a result**. The `andThen()` method chains multiple `Consumer` operations in order.

### **Example: Chaining `Consumer<T>` with `andThen()`**
```java
import java.util.function.Consumer;

public class ConsumerChainingDemo {
    public static void main(String[] args) {
        Consumer<String> first = s -> System.out.println("Step 1: " + s);
        Consumer<String> second = s -> System.out.println("Step 2: " + s.toUpperCase());
        Consumer<String> third = s -> System.out.println("Step 3: " + s.length());

        Consumer<String> pipeline = first.andThen(second).andThen(third);
        pipeline.accept("Hello");
    }
}
```
**Output:**
```
Step 1: Hello
Step 2: HELLO
Step 3: 5
```
---

## Chaining with `Function<T, R>.andThen()`
`Function<T, R>` represents a function that **takes an input and returns a result**. The `andThen()` method allows chaining functions where the output of one function becomes the input of the next.

### **Example: Chaining `Function<T, R>`**
```java
import java.util.function.Function;

public class FunctionChainingDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        Function<Integer, Integer> add3 = x -> x + 3;
        Function<Integer, String> toString = x -> "Result: " + x;

        Function<Integer, String> pipeline = multiplyBy2.andThen(add3).andThen(toString);
        System.out.println(pipeline.apply(5));
    }
}
```
**Output:**
```
Result: 13
```
---

## Chaining with `Predicate<T>.and()`, `or()`, and `negate()`
`Predicate<T>` represents a function that **takes an input and returns a boolean**. It supports logical operations like `and()`, `or()`, and `negate()`.

### **Example: Chaining `Predicate<T>`**
```java
import java.util.function.Predicate;

public class PredicateChainingDemo {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isPositive = x -> x > 0;

        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        Predicate<Integer> isEvenOrPositive = isEven.or(isPositive);
        Predicate<Integer> isNotEven = isEven.negate();

        int number = -4;
        System.out.println("Is Even & Positive: " + isEvenAndPositive.test(number));
        System.out.println("Is Even | Positive: " + isEvenOrPositive.test(number));
        System.out.println("Is Not Even: " + isNotEven.test(number));
    }
}
```
**Output:**
```
Is Even & Positive: false
Is Even | Positive: true
Is Not Even: false
```
---

## When to Use Lambda Chaining
✔ When multiple operations need to be **executed sequentially**.
✔ When defining **functional workflows** (e.g., data transformation pipelines).
✔ When using **functional interfaces** (`Consumer`, `Function`, `Predicate`) in Java 8+.
✔ When improving **code readability** by reducing nested lambdas.

---

## Conclusion
Chaining lambda expressions in Java using `andThen()`, `or()`, `negate()`, etc., **improves code modularity and readability**. This approach is widely used in **stream processing, event handling, and data transformations**.

---
### 📌 Want to Learn More?
- [Java 8 Functional Interfaces](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)
- [Lambda Expressions in Java](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

Feel free to ⭐ this repo if you found it useful!


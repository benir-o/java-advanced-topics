# Default Methods in Java

## Introduction
Default methods were introduced in **Java 8** to allow interfaces to have method implementations without breaking existing classes that implement the interface. This enables interface evolution while maintaining backward compatibility.

## Why Default Methods?
Before Java 8, all interface methods were **abstract**, meaning every implementing class had to define them. If a new method was added to an interface, all implementing classes had to update their implementation. **Default methods solve this problem** by allowing interfaces to provide a default implementation.

## Syntax
A default method in an interface uses the `default` keyword:

```java
interface MyInterface {
    default void show() {
        System.out.println("This is a default method");
    }
}
```

## Example Usage
### 1. Simple Default Method
```java
interface Printer {
    void print(String text);

    default void uppercasePrint(String text) {
        System.out.println(text.toUpperCase());
    }
}

class ConsolePrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}

public class DefaultMethodDemo {
    public static void main(String[] args) {
        ConsolePrinter printer = new ConsolePrinter();
        printer.print("hello");
        printer.uppercasePrint("hello");
    }
}
```
**Output:**
```
hello
HELLO
```

### 2. Using Default Method in Functional Interface (`Consumer<T> andThen`)
```java
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> first = s -> System.out.println("First: " + s);
        Consumer<String> second = s -> System.out.println("Second: " + s);

        Consumer<String> combined = first.andThen(second);
        combined.accept("Hello");
    }
}
```
**Output:**
```
First: Hello
Second: Hello
```

## Resolving Multiple Inheritance Conflicts
If a class implements multiple interfaces with the **same default method**, it must **override** the method to resolve ambiguity:

```java
interface A {
    default void show() { System.out.println("A's show"); }
}

interface B {
    default void show() { System.out.println("B's show"); }
}

class C implements A, B {
    @Override
    public void show() {
        System.out.println("Resolving conflict");
    }
}

public class Test {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
    }
}
```
**Output:**
```
Resolving conflict
```

## Advantages of Default Methods
✅ Allows adding new methods to interfaces without breaking existing code.
✅ Reduces code duplication by defining shared behavior.
✅ Supports method chaining in functional interfaces (e.g., `Consumer.andThen`).
✅ Enables **functional programming concepts** in Java.

## Limitations
🚫 Default methods **cannot override `Object` methods** (like `toString()` or `equals()`).
🚫 If multiple interfaces define the same default method, **explicit overriding** is required.
🚫 Can lead to complexity if overused.

## Conclusion
Default methods are a powerful feature in Java, **allowing interfaces to evolve without breaking implementations**. They enable cleaner, more maintainable code and are especially useful in functional programming patterns.

---
### 📌 Oracle Documentation
- [Oracle Documentation on Default Methods](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html)

Feel free to ⭐ this repo if you found it useful!

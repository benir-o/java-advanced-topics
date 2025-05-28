# Executors in Java

This project demonstrates the use of the `Executors` class in Java, which is part of the `java.util.concurrent` package. It simplifies working with threads by managing a pool of them, allowing you to focus on *what* work should be done rather than *how* to manage threads manually.

---

## 🔧 What is `Executors`?

The `Executors` class is a utility class that provides factory methods for creating different types of `ExecutorService` implementations.

### Common Methods:
- `Executors.newSingleThreadExecutor()`
- `Executors.newFixedThreadPool(int nThreads)`
- `Executors.newCachedThreadPool()`
- `Executors.newScheduledThreadPool(int corePoolSize)`

---

## 🧵 What is an `Executor`?

An `Executor` is a high-level interface for launching and managing threads. You submit tasks to it, and it runs them asynchronously.

---

## ✅ Benefits of Using `Executors`

- Thread reuse through a thread pool
- Better performance in high-load scenarios
- Clean and readable syntax for concurrent programming
- Avoids manual thread creation and management

---

## 🚀 Example: Submitting a Task with `newSingleThreadExecutor`

```java
import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> future = executor.submit(() -> {
                LongTask.simulate(); // sleeps for 3 seconds
                return 1;
            });

            System.out.println("Do more work...");

            Integer result = future.get(); // blocks until the task completes
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

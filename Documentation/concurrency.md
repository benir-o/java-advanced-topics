# 🚀 Multithreading and Concurrency in Java — Quick Notes

## 1. Process vs Thread
| Process | Thread |
|--------|--------|
| A running instance of a program. | A lightweight part of a process that can run independently. |
| Has its own memory. | Shares memory with other threads in the same process. |
| Heavyweight. | Lightweight. |

---

## 2. Concurrency and Multithreading in Java
- **Concurrency**: Dealing with multiple tasks at once (they may appear to run simultaneously).
- **Multithreading**: Running multiple threads within a single process for better CPU utilization.
- Java supports concurrency using:
  - `Thread` class
  - `Runnable` interface
  - `ExecutorService` (advanced)

---

## 3. Implementing Runnable Interface
- We implement `Runnable` to separate the thread **task** from the thread **control**.
- It allows us to create more flexible and reusable code.

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Running thread task...");
    }
}
```

## 4. Thread Class Taking a Runnable
- A `Thread` can take a `Runnable` object inside its constructor.
- This approach separates the task (what to do) from the thread (how to run it).

```java
Runnable task = new MyTask();
Thread thread = new Thread(task);
thread.start();
```

## 5. Pausing a thread (sleep)
- You can pause a thread temporarily using Thread.sleep(milliseconds).
- Sleep must be wrapped in a try-catch block because it throws an InterruptedException.

```java
try {
    Thread.sleep(1000); // Sleep for 1 second
} catch (InterruptedException e) {
    e.printStackTrace();
}

```
## 6. Uncertainty of Thread Execution Order
- When multiple threads are started, their execution order is unpredictable.
- Thread scheduling is handled by the operating system and JVM.


## 7. Joining Threads
- `join()` is used to **make one thread wait** for another thread to complete.
- It ensures that a specific thread has finished its task before the program moves forward.

Example:

```java
Thread t = new Thread(new MyTask());
t.start();
t.join(); // Main thread waits for t to finish





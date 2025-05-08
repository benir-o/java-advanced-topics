# Using Confinement to Prevent Race Conditions in Java

Confinement is a thread safety technique where you ensure data is only accessed from a single thread, eliminating the need for synchronization.

## Types of Confinement with Examples

### 1. Stack Confinement (Local Variables)
```java
public class StackConfinementExample {
    public void processData() {
        // Local variable - confined to this thread's stack
        List<Integer> numbers = new ArrayList<>();
        
        // Safe modification - only this thread can access
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
        
        System.out.println(numbers.size()); // Always 100
    }
}
```
### 2. Thread Confinement (ThreadLocal) 
```java
public class ThreadConfinementExample {
    private static final ThreadLocal<SimpleDateFormat> dateFormat =
        ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    
    public String formatDate(Date date) {
        // Each thread gets its own SimpleDateFormat instance
        return dateFormat.get().format(date);
    }
}
```
### 3. Object Confinement (Design Pattern)
```java
public class EmployeeManager {
    private final List<Employee> employees = new ArrayList<>();
    
    public synchronized void addEmployee(Employee e) {
        employees.add(e);
    }
    
    public synchronized List<Employee> getEmployees() {
        return new ArrayList<>(employees); // Defensive copy
    }
}
```
### 4. Producer-Consumer with queue confinement
```java
public class OrderProcessor {
    private final BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    
    public void submitOrder(Order order) {
        orderQueue.put(order); // Transfers ownership
    }
    
    public void processOrders() {
        while (true) {
            Order order = orderQueue.take(); // Now confined to consumer
            process(order);
        }
    }
    
    private void process(Order order) {
        // Safe processing
    }
}
```
### 5. Event Dispatch Thread Confinement
```java
public class GUIExample extends JFrame {
    private final DefaultListModel<String> model = new DefaultListModel<>();
    
    public GUIExample() {
        SwingUtilities.invokeLater(() -> {
            JList<String> list = new JList<>(model);
            add(new JScrollPane(list));
            
            model.addElement("First item"); // Safe on EDT
            model.addElement("Second item");
        });
    }
}
```
# 🥅 When to use confinement
- GUI applications (Swing/JavaFX)
- Request Processing in web servers
- Batch Processing Pipelines
- Worker thread patterns

package benir.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers= new ArrayList<>();
        customers.add(new Customer("Alicia", "alicia@gmail.com"));
        customers.add(new Customer("Becker", "becker@gmail.com"));
        customers.add(new Customer("Kylian", "kylian@gmail.com"));
        Collections.sort(customers,new EmailComparator());
        System.out.println(customers);
    }
}

package benir.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers= new ArrayList<>();
        customers.add(new Customer("Alicia"));
        customers.add(new Customer("Becker"));
        customers.add(new Customer("Kylian"));
        Collections.sort(customers);
        System.out.println(customers);
    }
}

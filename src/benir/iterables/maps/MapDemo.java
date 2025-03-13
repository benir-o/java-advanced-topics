package benir.iterables.maps;

import benir.collections.Customer;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void show(){
        List<Customer> customers= new ArrayList<>();
        for (var customer: customers)
            if (customer.getEmail()=="e1")
                System.out.println("Found!");

    }
}

package benir.iterables.maps;

import benir.collections.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void show(){
        Map<String,Customer> map= new HashMap<>();
        var c1= new Customer("Julian","j1@gmail.com");
        var c2= new Customer("Miguel","m1@gmail.com");
        map.put(c1.getEmail(),c1);
        map.put(c2.getEmail(),c2);
        var customer= map.get("j1@gmail.com");
        System.out.println(customer);
        //map.containsKey()
        //map.replace("e1", new Customer("a++","a@gmail.com")
        //map.keySet()--> Returns an iterable with which you could use a for loop
        //map.entrySet()--> Returns a set of entry of String ;K=V
        //
    }

    public static void main(String[] args) {
        MapDemo.show();
    }
}

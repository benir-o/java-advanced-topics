package benir.collections;

import benir.iterables.Collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void show(){
        List<String> list= new ArrayList<>();
        java.util.Collections.addAll(list,"g","h","o","a");
        //A method overload
        list.set(0,"a+");
        list.indexOf("h");
        list.add(0,"!");
        list.lastIndexOf("a");
        list.subList(0,2);

    }
}

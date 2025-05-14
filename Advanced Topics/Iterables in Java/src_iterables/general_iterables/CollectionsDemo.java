package general_iterables;

import java.util.*;
import java.util.Collections;


public class CollectionsDemo {
    public static void show(){
        Collection<String> collection= new ArrayList<>();


        Collections.addAll(collection,"a","b","c");

        String[] myArray=collection.toArray(new String[0]);
        Collection<String> other= new ArrayList<>();
        other.addAll(collection);
        System.out.println(collection==other);
        System.out.println(collection.equals(other));


        for (var item: myArray){
            System.out.println(item);
        }
        System.out.println(collection.isEmpty());

    }

}

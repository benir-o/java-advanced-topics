package general_iterables;

import java.util.*;
import java.util.Collections;

public class SetDemo {
    public static void show(){
        Set<String> set1= new HashSet<>(Arrays.asList("a","b","c"));
        Set<String> set2=new HashSet<>(Arrays.asList("b","c","d"));

        //Union-> Combination of two sets
//        set1.addAll(set2);
//        System.out.println(set1);
        //Intersection
//        set1.retainAll(set2);
//        System.out.println(set1);
        //Difference
        set1.removeAll(set2);
        System.out.println(set1);

        //The set interface does not guarantee the oder of items

    }
}

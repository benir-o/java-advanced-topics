package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show(){
        Collection<String> collection= new ArrayList();
        Collections.addAll(collection,"a","b","c");
        var containsA= collection.contains("a");
        System.out.println(containsA);
        Object[] ObjectArray=collection.toArray();
        String[] StringArray=collection.toArray(new String[0]);
        collection.remove("a");
        //collection.clear();
        System.out.println(collection.isEmpty());
        for(var item: collection) {
            System.out.println(item);
        }
        Collection<String> collection1= new ArrayList<>();
        Collections.addAll(collection1,"d","e","f");
        Collection<String> other= new ArrayList<>();
        other.addAll(collection1);
        System.out.println(collection1==other);
        System.out.println(collection1.equals(other));


    }
}

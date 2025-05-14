package general_iterables;

import java.util.ArrayList;
import java.util.List;

public class ListDemo{

    public static void show(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c");
        System.out.println(list);

    }
}

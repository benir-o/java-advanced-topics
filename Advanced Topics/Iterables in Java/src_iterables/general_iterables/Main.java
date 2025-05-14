package general_iterables;
import generics.GenericList;

public class Main {
    public static void main(String[] args) {
        CollectionsDemo.show();
        var list= new GenericList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        QueueDemo.show();
        SetDemo.show();

    }

}

package benir.generics;



public class Main {
    public static void main(String[] args) {
        var list = new GenericList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        var iterator=list.iterator();
        //[a,b,c]


        while (iterator.hasNext()){
            var current=iterator.next();
            System.out.println(current);
        }
    }
}

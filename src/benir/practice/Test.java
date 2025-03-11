package benir.practice;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        var myInt= new MyGenericClass<Integer,String>(5,"Kenya");
        var myDouble = new MyGenericClass<Double,Character>(3.3,'^');
        var myChar= new MyGenericClass<Character,Integer>('C',32);
        var myString = new MyGenericClass<String,String>("Benir","Exceptional");
        ArrayList<String> myList= new ArrayList<>();

        HashMap<Integer,String> mapping = new HashMap<>();
        //bounded types= tou can create the object of a generic class to have data of
        //specified derived types ex.Number

        System.out.println(myInt.getValue());
        System.out.println(myDouble.getValue());
        System.out.println(myChar.getValue());
        System.out.println(myString.getValue());
    }
}

package benir.lambdaExpressions;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo {
//class/object::method-name
    public static void show(){
        List<String> list =List.of("a","b","c");
        Consumer<String> print= item->System.out.println(item) ;
        Consumer<String> printUpperCase= item->System.out.println(item.toUpperCase());
        //list.forEach(print.andThen(printUpperCase));

        Supplier<Double> getRandom= ()->Math.random();
        //What is lazy evaluation?
        var random=getRandom.get();
        System.out.println(random);
        //Function interface
        Function<String,Integer> map= str->str.length();
        var length=map.apply("Sky");
        System.out.println(length);

        //"Key:Value"
        Function<String,String> replaceColon= str->str.replace(":","=");
        Function<String,String> addBraces=str->"{"+str+"}";
        //Declarative Programming
        var application=replaceColon
                .andThen(addBraces)
                .apply("Key:Value");
        System.out.println(application);
        var result=addBraces.compose(replaceColon).apply("Key:Value");
        System.out.println(result);

        Predicate<String> isLongerThan5=str->str.length()>5;
        System.out.println(isLongerThan5.test("Liam"));


    }

    public static void main(String[] args) {
        LambdaDemo.show();
    }
}


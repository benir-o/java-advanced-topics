package practice2;

import java.util.List;
import java.util.function.*;

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

        //Combining predicates
        Predicate<String> hasLeftBrace= str->str.startsWith("{");
        Predicate<String> hasRightBrace=str->str.endsWith("}");

        var checkThisOut=hasLeftBrace.and(hasRightBrace);
        System.out.println(checkThisOut.test("{Raul Jimenez}"));
        //a,b->a+b->square
        BinaryOperator<Integer> add=(a, b)->a+b;

        Function<Integer,Integer> square= a->a*a;

        var bodmas=add.andThen(square).apply(1,2);
        System.out.println(bodmas);

        UnaryOperator<Integer> squareit=n->n*n;
        UnaryOperator<Integer> increment=n->n+1;
        var myResult=increment.andThen(squareit).apply(1);
        System.out.println(myResult);

    }

    public static void main(String[] args) {
        LambdaDemo.show();
    }
}


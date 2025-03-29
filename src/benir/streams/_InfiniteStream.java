package benir.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class _InfiniteStream {
    public static void main(String[] args) {
        int [] numbers={1,2,3,4};
        //Arrays.stream(numbers).forEach(n-> System.out.println(n));
        //Lazy evaluation
        //Function is not called unless we execute using the System command
        var stream1=Stream.generate(()->Math.random());

//        stream1
//                .limit(3)
//                .forEach(n-> System.out.println(n));

        Stream
                .iterate(1,n->n+1)
                .limit(10)
                .forEach(n-> System.out.println(n));

    }

}

package benir.lambdaExpressions.practice1;

import java.util.List;

public class Cint {
    public static void showIt(){
        List<Integer> integers=List.of(1,2,3,4);
        integers.forEach(System.out::println);
        //Consumer
    }

    public static void main(String[] args) {
        Cint.showIt();
    }
}

package benir.lambdaExpressions;

public class LambdaDemo {
    public String prefix="-";

    public static void show(){
        greet(message-> System.out.println(message));
    }
    public static void greet(Printer printer){
        printer.print("Hello World");
    }
    //What is an anonymous inner class
    //Sometimes we do not need to explicitly create a class to implement
    //an interface
    //Lambda expression-> An anonymous function

}

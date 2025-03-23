package benir.lambdaExpressions;

public class LambdaDemo {
    public static void show(){
        greet(new ConsolePrinter());
    }
    public static void greet(Printer printer){
        printer.print("Hello World");
    }

}

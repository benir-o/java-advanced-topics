package benir.lambdaExpressions;

public class LambdaDemo {
    String message;
    public LambdaDemo(String message){

    }
    public void print(String message){
        System.out.println(message);
    }

    public void mitigation(){
        System.out.println("This is a mitigation factor");
    }
    public void acceleration(){
        System.out.println("This is an acceleration factor");
    }

    public static void show(){

        greet(message1->new LambdaDemo(message1));
        greet(LambdaDemo::new);
        //greet(demo::print);
        //class/object::method-name
    }
    public static void greet(Printer printer){
        printer.print("l2");
    }
    //What is an anonymous inner class
    //Sometimes we do not need to explicitly create a class to implement
    //an interface
    //Lambda expression-> An anonymous function

}

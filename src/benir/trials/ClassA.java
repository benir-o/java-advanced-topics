package benir.trials;

public class ClassA {
    public static void acceptIt(String a){
        System.out.println(a);
    }
    public static void doThis(ClassA item){
        acceptIt("you");
        item.acceptIt("me");

    }
    public String toString(){
        return "printing item";
    }

    public static void main(String[] args) {
        ClassA myThing= new ClassA();
        myThing.acceptIt("You");
    }

}

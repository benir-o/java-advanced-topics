package benir.generics;



public class Main {
    public static void main(String[] args) {
        System.out.println(Utils.max("Kenya","Uganda"));
        System.out.println("This is a push attempt");
        System.out.println("Attempt1");
        System.out.println("Attempt2");
        Utils.findObjects(1,"Benir");
        User u1= new Instructor(10);
        var L1= new GenericList<User>();
        Utils.findUser(u1);
        Utils.findUserList(L1);
    }
}

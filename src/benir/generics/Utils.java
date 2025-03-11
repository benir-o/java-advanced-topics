package benir.generics;

public class Utils {
    public static <T extends Comparable<T>>T max(T n1,T n2) {
        return (n1.compareTo(n2)<0) ? n2 : n1;
    }
    public static <K,V> void findObjects(K key, V value){
        System.out.println(key+":"+ value);
    }
    public static void findUser(User user){
        System.out.println(user);
    }
    //CAP #1 extends User
    //Instructor extends user
    public static void printUsers(GenericList<? super User> user){
        GenericList<Object> temp = new GenericList<>();
        Object x =user.get(0);
        user.add(new User(10));
        user.add(new Instructor(23));
    }

}

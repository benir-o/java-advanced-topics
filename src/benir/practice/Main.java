package benir.practice;

public class Main {
    public static void main(String[] args) {
        Integer [] intArray={1,2,3,4,5};
        Double[] doubleArray={5.5,4.3,3.4,1.1};
        Character[] charArray= {'H','E','L','L','O'};
        String [] stringArray={"B","Y","E"};

        System.out.println(getFirstElement(intArray));
        System.out.println(getFirstElement(doubleArray));
        System.out.println(getFirstElement(charArray));
        System.out.println(getFirstElement(stringArray));
    }
    public static <T>void displayArray(T[] array){
        for (T x: array){
            System.out.print(x+" ");
        }
        System.out.println();

    }
    public static <T> T getFirstElement(T[] array){
        return array[0];
    }
}

package benir.generics;


//This is a generic class
public class GenericList <T>{
    private T[] items = (T[])new Object[10];
    private int count;



    public void add(T item){
        items[count++]=item;
    }
    public T get (int position){
        return items[position];
    }

}

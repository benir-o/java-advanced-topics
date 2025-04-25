package benir.GPT_mutlithreading;

public class Main {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        t1.start(); //starts the thread
    }
    public static void func1(){
        //Thread class takes a runnable object
        Thread t1=new Thread(new MyRunnable());
        Runnable task=new MyRunnable();
        Thread t2=new Thread(task);
        t2.start();
        //When we call t2.start(), task.run() occurs behind the scenes
        //Thanks to the Java Virtual Machine
    }
}

package benir.multithreading;

public class Main {
    public static void main(String[] args) {
        /*
        How to start a thread
         */
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
//        ThreadDemo.threadJoining();
//        ThreadDemo.threadCancel();
        ThreadDemo.downloadStatus();
    }
}

package benir.GPT_mutlithreading;

public class Main {
    public static void main(String[] args) {
        downloadTenFiles();

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
    public static void startThread(){
        System.out.println(Thread.currentThread().getName());
        var downloadFile=new DownloadFileTask2();
        Thread t2=new Thread(downloadFile);
        //The code for downloading a thread gets executed
        //in a separate thread
        //Therefore achieving concurrency
        t2.start();
        /*
        Each Thread starts, executes a file and then dies
         */
    }
    public static void downloadTenFiles(){
        /*
        Running 10 download file tasks concurrently
         */
        System.out.println(Thread.currentThread().getName());
        for (var i=0;i<10;i++){
            Thread thread=new Thread(new DownloadFileTask2());
            thread.start();
            /*
            A thread starts each time we iterate over
            Threads run in parallel
             */
        }
    }
}

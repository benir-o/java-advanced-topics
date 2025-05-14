package GPT_mutlithreading;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        confinement();


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
    public static void pauseAThread(){
        /*
        Method has been implemented in the downloadTenFiles Method
         */
    }
    public static void joinAThread(){
        Thread thread=new Thread(new DownloadFileTask2());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File is ready to be scanned");
    }
    public static void interruptAThread(){
        System.out.println(Thread.currentThread().getName());
        var downloadFile=new DownloadFileTask2();
        Thread t1=new Thread(downloadFile);
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t1.interrupt();
    }
    public static void cancelDownload(){
        var status=new DownloadStatus2();
        Thread thread=new Thread(new DownloadFileTask3());
        thread.start();
        try {
            Thread.sleep(55);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }
    public static void RaceConditions(){

        /*
        Occurs when two threads compete to update values in memory,
        thus resulting in unexpected errors
         */
        List<Thread> threads=new ArrayList<>();
        var status=new DownloadStatus2();
        for (var i=0;i<10;i++){
            var thread=new Thread(new DownloadFileTask3());
            thread.start();
            threads.add(thread);
        }
        for (var thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(status.getTotalBytes());

    }
    //Confinement
    /*
    Instead of having a single status object being shared among many
    threads, instead we make each individual thread
    take its own status object
     */
    public static void confinement(){

        List<Thread> threads= new ArrayList<>();
        List<DownloadFileTask3> tasks=new ArrayList<>();
        for (var i=0;i<10;i++){
            var task=new DownloadFileTask3();
            tasks.add(task);
            var thread=new Thread(task);
            thread.start();
            threads.add(thread);
        }
        for (var thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        var totalBytes=
                tasks.stream()
                .map(t->t.getStatus().getTotalBytes())
                .reduce(Integer::sum);

        System.out.println(totalBytes);

    }
    public static void synchronize(){

    }


}

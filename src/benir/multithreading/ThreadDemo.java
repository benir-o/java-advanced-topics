package benir.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {
    public static void show(){
        System.out.println(Thread.currentThread().getName());
        for (var i=0;i<10;i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
        /*
        Let's say we want to download many files concurrently
        We create a for-loop that creates many threads at the same time
         */
    }
    public static void threadJoining(){
        Thread thread=new Thread(new DownloadFileTask());
        thread.start();
        try {
            thread.join();//Makes the main thread wait for the execution of the download thread;
        } catch (InterruptedException e) {
            System.out.println("Error here");
        }
        System.out.println("File is ready to be scanned");

    }
    //How to cancel threads
    public static void threadCancel(){
        Thread thread=new Thread(new DownloadFileTask());
        thread.start();
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread.interrupt();//Cancels the Download thread;
    }
    public static void downloadStatus(){
        var status=new DownloadStatus();
        List<Thread> threads=new ArrayList<>();
        for (int i=0;i<10;i++){
            var thread=new Thread(new DownloadFileTask(status));
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
        System.out.println(status.getTotalBytes());
    }

}

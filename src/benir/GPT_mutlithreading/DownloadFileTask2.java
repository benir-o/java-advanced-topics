package benir.GPT_mutlithreading;

public class DownloadFileTask2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Downloading a File: "+Thread.currentThread().getName());
        //The task that we are supposed to do
    }
}

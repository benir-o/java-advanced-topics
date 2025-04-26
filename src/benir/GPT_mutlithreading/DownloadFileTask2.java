package benir.GPT_mutlithreading;

public class DownloadFileTask2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Downloading a File: "+Thread.currentThread().getName());
        //The task that we are supposed to do
        /*
        What if we would like to delay the thread for 5 seconds?
         */
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Download complete: "+ Thread.currentThread().getName());

    }
}

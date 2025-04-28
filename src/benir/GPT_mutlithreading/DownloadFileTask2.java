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
            System.out.println("Download complete: "+ Thread.currentThread().getName());

        } catch (InterruptedException e) {
            System.out.println("Download interrupted");
        }

    }
}
class DownloadFileTask3 implements Runnable{

    @Override
    public void run() {
        System.out.println("Downloading a File: "+Thread.currentThread().getName());
        for (var i=0;i<Integer.MAX_VALUE;i++){
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Download interrupted");
                break;
            }
            System.out.println("Downloading byte "+i);
            System.out.println("Download Complete"+ Thread.currentThread().getName());
        }
    }
}

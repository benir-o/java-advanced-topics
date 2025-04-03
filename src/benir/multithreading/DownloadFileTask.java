package benir.multithreading;

public class DownloadFileTask implements Runnable{


    /*
    DownloadFileTask is a runnable task since it implements the Runnable interface
    This can be passed as a parameter when creating an instance of the Thread class.
     */
    @Override
    public void run() {
        System.out.println("Downloading a file: "+Thread.currentThread().getName());
        /*
        We would like to delay the execution of a thread by a few milliseconds,
        so we use the static method sleep that takes in a parameter
        requiring the number of milliseconds
         */
        for (var i=0;i<Integer.MAX_VALUE;i++){
            if (Thread.currentThread().isInterrupted()) return;
            System.out.println("Downloading byte:"+i);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Download complete:"+Thread.currentThread().getName());
    }
}

package benir.multithreading;

public class DownloadFileTask implements Runnable{


    private DownloadStatus status;

    public DownloadFileTask(){
        this.status=new DownloadStatus();

    }
    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

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
        for (var i=0;i<10_000;i++){
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementTotalBytes();

        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Download complete:"+Thread.currentThread().getName());
    }
    public DownloadStatus getStatus() {
        return status;
    }
}

package benir.multithreading;

public class DownloadFileTask implements Runnable{


    @Override
    public void run() {
        System.out.println("Downloading a file");
    }
}

package benir.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private volatile boolean isDone;
    private int totalBytes;
    private int totalFiles;
    private Object totalBytesLock=new Object();
    /*
    We ensure that only one thread at a time can
    increment this field
     */



    private Lock lock=new ReentrantLock();
    public int getTotalBytes() {
        return totalBytes;
    }
    /*
    Instead of using the lock method, we can use the
    synchronized keyword
     */
    public void incrementTotalBytes(){
        synchronized (totalBytesLock){
            totalBytes++;
        }
    }
    public synchronized void incrementTotalFiles(){
        totalFiles++;
    }
    public boolean isDone(){
        return isDone;
    }
    public void done(){
        isDone=true;
    }

}

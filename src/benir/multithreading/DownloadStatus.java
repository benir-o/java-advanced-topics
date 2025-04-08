package benir.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    /*
    We ensure that only one thread at a time can
    increment this field
     */

    private Lock lock=new ReentrantLock();
    public int getTotalBytes() {
        return totalBytes;
    }
    public void incrementTotalBytes(){
        lock.lock();
        try{
            totalBytes++;
        }
        finally{
            lock.unlock();
        }

    }
}

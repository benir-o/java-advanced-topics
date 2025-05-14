package multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private volatile boolean isDone;
    private AtomicInteger totalBytes;
    private int totalFiles;
    private Object totalBytesLock=new Object();
    /*
    We ensure that only one thread at a time can
    increment this field
     */



    private Lock lock=new ReentrantLock();
    public int getTotalBytes() {
        return totalBytes.get();
    }
    /*
    Instead of using the lock method, we can use the
    synchronized keyword
     */
    public void incrementTotalBytes(){
        synchronized (totalBytesLock){
            totalBytes.incrementAndGet();//++a
            //getAndIncrement()==a++
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
/*
What is a compare and swap operation?
 */
}

package benir.GPT_mutlithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus2 {
    private int totalBytes;
    private int totalFiles;
    private Object totalBytesLock= new Object();
    private Object totalFilesLock= new Object();
    private Lock lock=new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }
    public void incrementTotalBytesByLocking(){
        //Allows each individual thread to be updated without interruption
        lock.lock();
        try {
            totalBytes++;
        }finally {
            lock.unlock();
        }
    }
    public void incrementTotalBytesBySynchronization(){
        synchronized (totalBytesLock){
            totalBytes++;
        }
    }
    public void incrementTotalFiles(){
        synchronized (totalFilesLock){
            totalFiles++;
        }

    }
    public int getTotalFiles() {
        return totalFiles;
    }


}

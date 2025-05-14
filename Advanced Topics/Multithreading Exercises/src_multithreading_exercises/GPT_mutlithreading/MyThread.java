package GPT_mutlithreading;
/*
We extend the thread class in order to get the method run
 */
public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread is running...");
    }
}

package executor;

import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show(){
        //Don't create an executor class immediately
        //The constructor has many parameters to pass
        //Executors.newSingleThreadExecutor();
        /*
        This returns a single executor thread
        scheduledThreadPool->returns an instance of the
        scheduled threadpool executor
         */
        var executor=Executors.newFixedThreadPool(2);
        //creating an executor that contains 2 threads.
        /*
        We can then submit a task to the threadPool we have created
         */

        try{
            executor.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }finally{
            executor.shutdown();
        }

        /*
        When we start an executor and submit a task, the
        executor thinks there might be more tasks coming in the future.
        So executor stays in memory waiting for new tasks.

        we should call shutdown.
        The method Waits for completion of current tasks without allowing new
        tasks to be let in.

        At times, we may run into an error before calling executor.shutdown, so it is necessary
        we wrap the executors.submit() in a try finally block.

        While the executor framework handles thread manipulation for us,
        it does not prevent the programmer from encountering race conditions.

         */



    }

    public static void main(String[] args) {
        show();
    }
}

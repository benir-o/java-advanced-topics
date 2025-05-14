package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show(){
        /*
        Executing a task on a single thread
         */
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            executor.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }finally{
            executor.shutdown();
        }




    }
}


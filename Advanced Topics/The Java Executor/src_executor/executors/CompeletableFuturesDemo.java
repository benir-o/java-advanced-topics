package executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompeletableFuturesDemo {
    public static void show(){
        /*
        runAsync--If we don't pass an executor object to the
        runAsync method, this method will run our task in a common
        pool

        ForkJoinPool:
        Fork-- Split a bigger task into smaller subtasks
        Join-- Combine the results of the subtasks once they are finished

        Commonpool()-- Returns the default shared thread pool
        used by Java for parallel tasks **Especially when
        you don't explicitly provide an executor.

        ForkJoinPool.Commonpool()--returns the pool that
        is used by the completableFuture class. So if we do
        not include an executor, this is what runs in the background.

        Runtime.getRuntime().availableProcessors():
        The common pool is based on the number of available threads.




         */
        Supplier<Integer> task=()->1;
        var future= CompletableFuture.supplyAsync(task);

        try {
            var result=future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    public static void passRunnableObject(){
        /*
        Create a runnable object and make a supplier method
        When we pass task to the runAsync method, it returns a
        completable future object of type void

        So what is the difference between runAsync and
        supplyAsync?

        1. Use runAsync when you just want to do something in the
        background
        2. Use supplyAsync when you want to get something
        from the background.
        -- runAsync just runs a runnable object, like task which we
        have created
        -- supplyAsync- runs a supplier<T> that returns a result.
         */
        Runnable task=()-> System.out.println("a");
        var future=CompletableFuture.runAsync(task);

    }
}

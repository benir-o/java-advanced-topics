package executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompeletableFuturesDemo {
    public static CompletableFuture<String> getUserEmail(){
        return CompletableFuture.supplyAsync(()->"email");
    }
    public static CompletableFuture<String> getPlaylist(String email){
        return CompletableFuture.supplyAsync(()->"playlist");
    }
    public static int toFahrenheit(int celsius){
        return (int) (celsius*1.8)+32;
    }
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
        CompletableFuture<Void> future=CompletableFuture.runAsync(task);
    }
    public static void codeCompletion(){
        CompletableFuture<Integer> future= CompletableFuture.supplyAsync(()->1);
        /*
        CompletionStage x;-- Represents a step in an asynchronous operation
         */
        future.thenRunAsync(()-> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Done");
        });
    }
    public static void supplyStuff(){
        var future=CompletableFuture.supplyAsync(()->1);
        CompletableFuture<Void> finish=future.thenAccept(result->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });
    }
    public static void handleExceptions(){
        CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->{
            System.out.println("Getting the current weather");
            throw new IllegalStateException();
        });
        try {
            var temperature=future.exceptionally(ex->1).get();
            System.out.println(temperature);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.getCause();//Returns the cause of the exception
            e.printStackTrace();
        }

    }
    public static void transformer(){
        /*
        Sometimes we need to transform the results of an asynchronous task.
         */
        var future=CompletableFuture.supplyAsync(()->20);
        try {
            var result=future
                    .thenApply(CompeletableFuturesDemo::toFahrenheit)
                    .get();
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    public static void FahrenheitTransformer(){
        var future=CompletableFuture.supplyAsync(()->20);
        future
                .thenApply(CompeletableFuturesDemo::toFahrenheit)
                .thenAccept(f-> System.out.println(f));

    }
    public static void composingCompletableFutures(){
        /*
        We want to return the second task upon completion
        of the first task.

        A function that maps a string to a new CompletionStage Object
         */
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "email");
        future.thenCompose(
                email->CompletableFuture.supplyAsync(()->"playlist")
        ).thenAccept(playlist-> System.out.println(playlist));
    }
    public static void advancedComposition(){
        getUserEmail().thenCompose(
                CompeletableFuturesDemo::getPlaylist
        ).thenAccept(playlist-> System.out.println(playlist));
    }
}

package executors;

public class TestFutures {
    public static void main(String[] args) {
        //CompeletableFuturesDemo.codeCompletion();
        /*
        What is the difference between thenRun and
        thenRunAsync?

        thenRun-- Runs in the same thread as the previous task
        thenRunAsync-- Runs in a different thread, usually from
        the common pool.

        thenAccept
        thenAcceptAsync

        Exceptionally returns a new Completable Future.
        Philosophy: If an exception is thrown, then we return a default value
         */
        //CompeletableFuturesDemo.supplyStuff();
        CompeletableFuturesDemo.handleExceptions();
    }
}

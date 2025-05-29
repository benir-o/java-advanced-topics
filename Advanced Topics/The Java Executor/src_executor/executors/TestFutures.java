package executors;

public class TestFutures {
    public static void main(String[] args) {
        CompeletableFuturesDemo.codeCompletion();
        /*
        What is the difference between thenRun and
        thenRunAsync?

        thenRun-- Runs in the same thread as the previous task
        thenRunAsync-- Runs in a different thread, usually from
        the common pool.

        thenAccept
        thenAcceptAsync
         */
        CompeletableFuturesDemo.supplyStuff();
    }
}

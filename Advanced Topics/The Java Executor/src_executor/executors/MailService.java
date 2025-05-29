package executors;

import java.util.concurrent.CompletableFuture;

public class MailService {
    /*
    We use this class to send Emails to our users.
     */
    public void send(){
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }
    public CompletableFuture<Void> sendAsync(){
        return CompletableFuture.runAsync(()->send());
    }

    public static void main(String[] args) {
        var service=new MailService();
        service.sendAsync();
        System.out.println("Hello World!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

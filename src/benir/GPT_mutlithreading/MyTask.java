package benir.GPT_mutlithreading;

class MyTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        }
    }

    public static void main(String[] args) {
        Thread t=new Thread(new MyTask());
        t.start();
    }
    //comment
}




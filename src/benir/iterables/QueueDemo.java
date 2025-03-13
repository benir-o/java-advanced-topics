package benir.iterables;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show(){
        Queue<String> queue= new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");

        //d->b->a ->c
        var front = queue.peek();
        //peek returns null when the queue is empty
        //element throws an exception when the queue is empty
        System.out.println(front);//displays the item at the front of the queue
        var remove = queue.remove();
        //Removes the item at the front of the queue
        System.out.println(queue);
//        queue.poll() returns null
//        queue.remove() returns an exception

    }
}

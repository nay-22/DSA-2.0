package Queue;

import Queue.Interface.Queue;
import Queue.SinglyEnded.ArrayQueue;

public class QueueRunner {
    public static void main(String[] args) throws Exception {
        Queue<Integer> aq = new ArrayQueue<>(7);
        aq.offer(10);
        aq.offer(20);
        aq.offer(30);
        aq.offer(40);
        aq.offer(50);
        aq.offer(60);
        aq.offer(70);
        System.out.println(aq);
        System.out.println(aq.size());
        aq.poll();
        System.out.println("poll(10)" + aq);
        aq.poll();
        System.out.println("poll(20)" + aq);
        aq.poll();
        System.out.println("poll(30)" + aq);
        aq.poll();
        System.out.println("poll(40)" + aq);
        aq.poll();
        System.out.println("poll(50)" + aq);
        aq.poll();
        System.out.println("poll(60)" + aq);
        // aq.poll();
        // System.out.println("poll(70)" + aq);

        // Overflow Exception 
        // => Limitation of ArrayQueue due to front++ at each poll(), decreases capacity
        // => Solution: Queue based on Linked List or Circular Queue
        aq.offer(70); 

        // aq.offer(80);
        // aq.offer(90);
        // aq.offer(100);
        // aq.offer(110);
        // aq.offer(120);
        // aq.offer(130);
        // aq.offer(140);
        // System.out.println(aq);
        // System.out.println(aq.peek());
    }
}

package Queue;

import Queue.Interface.Queue;
import Queue.SinglyEnded.ArrayQueue;
import Queue.SinglyEnded.LinkedQueue;

public class QueueRunner {
    public static void main(String[] args) throws Exception {
        // Queue<Integer> queue = new ArrayQueue<>(7);
        Queue<Integer> queue = new LinkedQueue<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.poll();
        System.out.println("poll(10): " + queue);
        queue.poll();
        System.out.println("poll(20): " + queue);
        queue.poll();
        System.out.println("poll(30): " + queue);
        queue.poll();
        System.out.println("poll(40): " + queue);
        queue.poll();
        System.out.println("poll(50): " + queue);
        queue.poll();
        System.out.println("poll(60): " + queue);
        queue.poll();
        System.out.println("poll(70): " + queue);
        queue.poll();
        System.out.println("Empty poll" + queue); // Queue Undeflow

        // Overflow Exception 
        // => Limitation of ArrayQueue due to front++ at each poll(), decreases capacity
        // => Solution: Queue based on Linked List or Circular Queue
        // queue.offer(70); 

        // queue.offer(80);
        // queue.offer(90);
        // queue.offer(100);
        // queue.offer(110);
        // queue.offer(120);
        // queue.offer(130);
        // queue.offer(140);
        System.out.println(queue);
        // System.out.println(queue.peek());
    }
}

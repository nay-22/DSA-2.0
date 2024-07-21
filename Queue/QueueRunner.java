package Queue;

import Queue.DoublyEnded.ArrayDeque;
import Queue.Interface.Dequeue;
import Queue.Interface.Queue;
import Queue.SinglyEnded.ArrayQueue;
import Queue.SinglyEnded.LinkedQueue;

public class QueueRunner {
    public static void main(String[] args) throws Exception {
        // testArrayDequeue();
        testArrayQueue();
    }

    private static void testArrayQueue() throws Exception {
        Queue<Integer> queue = new ArrayQueue<>(7);
        queue.offerLast(10);
        queue.offerLast(20);
        queue.offerLast(30);
        System.out.println(queue); // [10, 20, 30]

        

        queue.pollFirst();
        queue.pollFirst();
        System.out.println(queue); // [30], but two spaces wasted at front

        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        System.out.println(queue);

        // Queue Overflow, due to front spaces being wasted, ArrayQueue Limitation
        // queue.offer(80);
        // System.out.println(queue);

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll(); // polling of the only element resets the front and rear to free all spaces upto capacity
        System.out.println(queue); // [], front = -1, rear = -1

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        System.out.println(queue); // [10, 20, 30, 40, 50, 60, 70]

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();

        // Queue Overflow, due to front spaces being wasted, ArrayQueue Limitation
        queue.offer(80);

    }

    private static void testArrayDequeue() throws Exception {
        Dequeue<Integer> queue = new ArrayDeque<>(7);
        queue.offerLast(10);
        queue.offerLast(20);
        queue.offerLast(30);
        System.out.println(queue); // [10, 20, 30]

        // throws Exception saying "Front space not available..."
        // queue.offerFirst(40);
        // System.out.println(queue);

        queue.pollFirst();
        queue.pollFirst();
        System.out.println(queue); // [30], but two front spaces available

        queue.offerFirst(40);
        queue.offerFirst(50);
        System.out.println(queue); // [50, 40, 30]

        // throws Exception saying "Front space not available..."
        // queue.offerFirst(60);
        // System.out.println(queue);

        queue.pollFirst();
        queue.pollFirst();
        queue.pollFirst();
        System.out.println(queue); // but now front = -1 & rear = -1, queue empty

        queue.offerFirst(10);
        System.out.println(queue);

        // throws Exception saying "Front space not available..."
        // queue.offer(20);
        // System.out.println(queue);
    }
}

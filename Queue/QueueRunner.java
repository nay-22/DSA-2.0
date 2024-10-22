package Queue;

import Queue.Circular.CircularArrayDeque;
import Queue.Circular.CircularArrayQueue;
import Queue.Circular.CircularLinkedDeque;
import Queue.Circular.CircularLinkedQueue;
import Queue.DoublyEnded.ArrayDeque;
import Queue.DoublyEnded.LinkedDeque;
import Queue.Interface.Dequeue;
import Queue.Interface.Queue;
import Queue.SinglyEnded.ArrayQueue;
import Queue.SinglyEnded.LinkedQueue;

@SuppressWarnings("unused")
public class QueueRunner {
    public static void main(String[] args) throws Exception {
        // testArrayQueue();
        // testLinkedQueue();
        // testArrayDequeue();
        // testLinkedDequeue();
        // testCircularArrayQueue();
        // testCircularArrayDequeue();
        // testCircularLinkedQueue();
        testCircularLinkedDequeue();
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
        queue.poll(); // polling of the only element resets the front and rear to free all spaces upto
                      // capacity
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

    private static void testLinkedQueue() throws Exception {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.offerLast(10);
        queue.offerLast(20);
        queue.offerLast(30);
        System.out.println(queue); // [10, 20, 30]

        queue.pollFirst();
        queue.pollFirst();
        System.out.println(queue); // [30]

        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        System.out.println(queue);
        queue.offer(80);
        System.out.println(queue);

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue); // [80]

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        System.out.println(queue); // [80, 10, 20, 30, 40, 50, 60, 70]

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue); // []

        // Queue Underflow
        queue.poll();
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
    }

    private static void testLinkedDequeue() throws Exception {
        Dequeue<Integer> queue = new LinkedDeque<>();
        queue.offerLast(10);
        queue.offerLast(20);
        queue.offerLast(30);
        System.out.println(queue); // [10, 20, 30]

        queue.pollFirst();
        queue.pollFirst();
        System.out.println(queue); // [30]

        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        System.out.println(queue); // [30, 40, 50, 60, 70]

        queue.offer(80);
        System.out.println(queue); // [30, 40, 50, 60, 70]

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue); // [80]

        queue.offerFirst(10);
        queue.offerFirst(20);
        System.out.println(queue); // [20, 10, 80]

        queue.poll();
        queue.poll();
        queue.poll();

        // Queue Underflow
        // queue.poll();

        queue.offerFirst(10);
        queue.offerFirst(20);
        queue.offerFirst(30);
        queue.offerFirst(40);
        System.out.println(queue); // [40, 30, 20, 10]

        queue.pollFirst();
        System.out.println(queue); // [30, 20, 10]

        queue.pollFirst();
        System.out.println(queue); // [20, 10]

        queue.pollFirst();
        System.out.println(queue); // [10]

        queue.pollFirst();
        System.out.println(queue); // []

        // Queue Underflow
        queue.pollFirst();

    }

    private static void testCircularArrayQueue() throws Exception {
        // Queue<Integer> queue = new CircularArrayQueue<>(7); // No access to
        // internal() method
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>(7); // Access internal() method
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        System.out.println(queue); // [10, 20, 30, 40, 50, 60, 70]

        // Queue Overflow
        // queue.offer(80);

        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue); // [40, 50, 60, 70]

        queue.offer(80);
        queue.offer(90);
        queue.offer(100);

        // Actual internal queue => // [80, 90, 100, 40, 50, 60, 70]
        System.out.println(queue.internal());
        System.out.println(queue); // [40, 50, 60, 70, 80, 90, 100]

        // Queue Overflow
        // queue.offer(110);

        queue.poll();
        queue.poll();

        // Actual internal queue => [80, 90, 100, null, null, 60, 70]
        System.out.println(queue.internal());
        System.out.println(queue); // [60, 70, 80, 90, 100]

        queue.offer(110);
        queue.poll();
        queue.poll();

        // Actual internal queue => [80, 90, 100, 110, null, null, null]
        System.out.println(queue.internal());
        System.out.println(queue); // [80, 90, 100, 110]

        queue.poll();

        // Actual internal queue => [null, 90, 100, 110, null, null, null]
        System.out.println(queue.internal());
        System.out.println(queue); // [90, 100, 110]

        queue.poll();
        queue.poll();
        queue.poll();

        // Actual internal queue => [null, null, null, null, null, null, null]
        System.out.println(queue.internal());
        System.out.println(queue); // []

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        // Actual internal queue => [null, null, null, null, null, null, null]
        System.out.println(queue.internal());
        System.out.println(queue); // []
    }

    private static void testCircularArrayDequeue() throws Exception {
        // Dequeue<Integer> queue = new CircularArrayDeque<>(7); // No access to
        // internal() method
        CircularArrayDeque<Integer> queue = new CircularArrayDeque<>(7); // Access internal() method
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        System.out.println(queue); // [10, 20, 30, 40, 50, 60, 70]

        // Queue Overflow
        // queue.offer(80);

        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue); // [40, 50, 60, 70]

        queue.offer(80);
        queue.offer(90);
        queue.offer(100);

        // Actual internal queue => // [80, 90, 100, 40, 50, 60, 70]
        System.out.println(queue.internal());
        System.out.println(queue); // [40, 50, 60, 70, 80, 90, 100]

        // Queue Overflow
        // queue.offer(110);

        queue.poll();
        queue.poll();

        // Actual internal queue => [80, 90, 100, null, null, 60, 70]
        System.out.println(queue.internal());
        System.out.println(queue); // [60, 70, 80, 90, 100]

        queue.offer(110);
        queue.poll();
        queue.poll();

        // Actual internal queue => [80, 90, 100, 110, null, null, null]
        System.out.println(queue.internal());
        System.out.println(queue); // [80, 90, 100, 110]

        queue.poll();

        // Actual internal queue => [null, 90, 100, 110, null, null, null]
        System.out.println(queue.internal());
        System.out.println(queue); // [90, 100, 110]

        queue.poll();
        queue.poll();
        queue.poll();

        // Actual internal queue => [null, null, null, null, null, null, null]
        System.out.println(queue.internal());
        System.out.println(queue); // []

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);

        // Actual internal queue => [10, 20, 30, 40, 50, 60, null]
        System.out.println(queue.internal());
        System.out.println(queue); // [10, 20, 30, 40, 50, 60]

        System.out.println("peekLast() => " + queue.peekLast()); // 60

        queue.poll();
        queue.poll();
        queue.poll();

        // Actual internal queue => [null, null, null, 40, 50, 60, null]
        System.out.println(queue.internal());
        System.out.println(queue); // [40, 50, 60]

        queue.offerFirst(70);
        queue.offerFirst(80);

        // Actual internal queue => [null, 80, 70, 40, 50, 60, null]
        System.out.println(queue.internal());
        System.out.println(queue); // [80, 70, 40, 50, 60]

        queue.offerFirst(90);

        // Actual internal queue => [90, 80, 70, 40, 50, 60, null]
        System.out.println(queue.internal());
        System.out.println(queue); // [90, 80, 70, 40, 50, 60]

        queue.offerFirst(100);

        // Actual internal queue => [90, 80, 70, 40, 50, 60, 100]
        System.out.println(queue.internal());
        System.out.println(queue); // [100, 90, 80, 70, 40, 50, 60]

        // Queue Overflow
        // queue.offerFirst(110);

        queue.pollLast();
        queue.pollLast();

        // Actual internal queue => [90, 80, 70, 40, null, null, 100]
        System.out.println(queue.internal());
        System.out.println(queue); // [100, 90, 80, 70, 40]

        queue.offerFirst(110);
        queue.offerFirst(120);

        // Actual internal queue => [90, 80, 70, 40, 120, 110, 100]
        System.out.println(queue.internal());
        System.out.println(queue); // [120, 110, 100, 90, 80, 70, 40]

        queue.pollLast();
        queue.pollLast();

        // Actual internal queue => [90, 80, null, null, 120, 110, 100]
        System.out.println(queue.internal());
        System.out.println(queue); // [120, 110, 100, 90, 80]

        queue.pollLast();
        queue.pollLast();

        // Actual internal queue => [null, null, null, null, 120, 110, 100]
        System.out.println(queue.internal());
        System.out.println(queue); // [120, 110, 100]

        queue.pollLast();
        queue.pollLast();

        // Actual internal queue => [null, null, null, null, 120, null, null]
        System.out.println(queue.internal());
        System.out.println(queue); // [120]

        queue.pollLast();

        // Actual internal queue => [null, null, null, null, null, null, null]
        System.out.println(queue.internal());
        System.out.println(queue); // []

        // Queue Underflow
        queue.pollLast();

    }

    private static void testCircularLinkedQueue() throws Exception {

        CircularLinkedQueue<Integer> queue = new CircularLinkedQueue<>(); // Access internal() method

        System.out.println(queue.isEmpty());

        queue.offer(10);
        System.out.println(queue); // [10]
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
        System.out.println(queue); // [40, 50, 60, 70]

        queue.offer(80);
        queue.offer(90);
        queue.offer(100);

        System.out.println(queue); // [40, 50, 60, 70, 80, 90, 100]


        queue.poll();
        queue.poll();

        System.out.println(queue); // [60, 70, 80, 90, 100]

        queue.offer(110);
        queue.poll();
        queue.poll();

        System.out.println(queue); // [80, 90, 100, 110]

        queue.poll();

        System.out.println(queue); // [90, 100, 110]

        queue.poll();
        System.out.println(queue); // [100, 110]

        queue.poll();
        System.out.println(queue); // [110]

        queue.poll();
        System.out.println(queue); // []

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        System.out.println(queue); // [10, 20, 30, 40]
    }

    private static void testCircularLinkedDequeue() throws Exception {
        CircularLinkedDeque<Integer> queue = new CircularLinkedDeque<>();
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
        System.out.println(queue); // [40, 50, 60, 70]

        queue.offer(80);
        queue.offer(90);
        queue.offer(100);

        System.out.println(queue); // [40, 50, 60, 70, 80, 90, 100]


        queue.poll();
        queue.poll();

        System.out.println(queue); // [60, 70, 80, 90, 100]

        queue.offer(110);
        queue.poll();
        queue.poll();

        System.out.println(queue); // [80, 90, 100, 110]

        queue.poll();

        System.out.println(queue); // [90, 100, 110]

        queue.poll();
        queue.poll();
        queue.poll();

        System.out.println(queue); // []

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);

        System.out.println(queue); // [10, 20, 30, 40, 50, 60]

        System.out.println("peekLast() => " + queue.peekLast()); // 60

        queue.poll();
        queue.poll();
        queue.poll();

        System.out.println(queue); // [40, 50, 60]

        queue.offerFirst(70);
        queue.offerFirst(80);

        System.out.println(queue); // [80, 70, 40, 50, 60]

        queue.offerFirst(90);

        System.out.println(queue); // [90, 80, 70, 40, 50, 60]

        queue.offerFirst(100);

        System.out.println(queue); // [100, 90, 80, 70, 40, 50, 60]

        queue.pollLast();
        queue.pollLast();

        System.out.println(queue); // [100, 90, 80, 70, 40]

        queue.offerFirst(110);
        queue.offerFirst(120);

        System.out.println(queue); // [120, 110, 100, 90, 80, 70, 40]

        queue.pollLast();
        queue.pollLast();

        System.out.println(queue); // [120, 110, 100, 90, 80]

        queue.pollLast();
        queue.pollLast();

        System.out.println(queue); // [120, 110, 100]

        queue.pollLast();
        queue.pollLast();

        System.out.println(queue); // [120]

        queue.pollLast();

        System.out.println(queue); // []

        // Queue Underflow
        queue.pollLast();

    }
}

package Queue.DoublyEnded;

import Queue.Interface.Dequeue;
import Queue.SinglyEnded.ArrayQueue;

public class ArrayDeque<T> extends ArrayQueue<T> implements Dequeue<T> {

    public ArrayDeque(int capacity) {
        super(capacity);
    }

    @Override
    public boolean isFull() {
        return rear == capacity - 1 && front == 0;
    }

    @Override
    public boolean isEmpty() {
        return rear == -1 || front == -1;
    }

    @Override
    public void offerFirst(T data) throws Exception {
        if (isFull()) throw new Exception("Queue Overflow");
        if (front == 0) throw new Exception("Front space not available; Try insertion from rear");
        if (isEmpty()) {
            front++;
            rear++;
            queue[front] = data;
            return;
        }
        queue[--front] = data;
    }

    @Override
    public T pollLast() throws Exception {
        if (isEmpty()) throw new Exception("Queue Underflow");
        T data = queue[--rear];
        if (rear < front) {
            front = -1;
            rear = -1;
        }
        return data;
    }

    @Override
    public T peekLast() throws Exception {
        if (isEmpty()) throw new Exception("Queue Underflow");
        return queue[rear];
    }

}

package Queue.Circular;

import Queue.Interface.Dequeue;

public class CircularArrayDeque<T> extends CircularArrayQueue<T> implements Dequeue<T> {

    public CircularArrayDeque(int capacity) {
        super(capacity);
    }

    @Override
    public void offerFirst(T data) throws Exception {
        if (isFull()) throw new Exception("Queue Overflow");
        if (front == 0) front = capacity - 1;
        else front = (front - 1) % capacity;
        queue[front] = data;
    }

    @Override
    public T pollLast() throws Exception {
        if (isEmpty()) throw new Exception("Queue Undeflow");
        T data = queue[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else if (rear == 0) rear = capacity - 1;
        else rear = (rear - 1) % capacity;
        return data;
    }

    @Override
    public T peekLast() throws Exception {
        if (isEmpty()) throw new Exception("Queue Undeflow");
        return queue[rear];
    }
    
}

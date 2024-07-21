package Queue.SinglyEnded;

import Queue.Interface.Queue;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements Queue<T> {
    protected int rear;
    protected int front;
    protected int capacity;
    protected T[] queue;

    public ArrayQueue(int capacity) {
        this.rear = -1;
        this.front = -1;
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
    }

    @Override
    public void offer(T data) throws Exception {
        offerLast(data);
    }

    @Override
    public void offerLast(T data) throws Exception {
        if (isFull()) throw new Exception("Queue Overflow");
        if (isEmpty()) {
            front = 0;
            rear = 0;
            queue[rear] = data;
        } else queue[++rear] = data;
    }

    @Override
    public T poll() throws Exception {
        return pollFirst();
    }

    @Override
    public T pollFirst() throws Exception {
        if (isEmpty()) throw new Exception("Queue Underflow");
        T data = queue[front++];
        if (front > rear) {
            front = -1;
            rear = -1;
        }
        return data;
    }

    @Override
    public T peek() throws Exception {
        return peekFirst();
    }

    @Override
    public T peekFirst() throws Exception {
        if (isEmpty()) throw new Exception("Queue Underflow");
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        return rear == capacity - 1;
    }

    @Override
    public int size() {
        return front != -1 ? rear - front : 0;
    }

    @Override
    public String toString() {
        // System.out.println("front = " + front);
        // System.out.println("rear = " + rear);
        if (front == -1) return "[]";
        StringBuilder str = new StringBuilder("[");
        for (int i = front; i <= rear; i++) {
            if (i < rear) str.append(queue[i]).append(", ");
            else str.append(queue[i]);
        }
        str.append("]");
        return str.toString();
    }

    

}

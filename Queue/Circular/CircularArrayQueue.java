package Queue.Circular;

import Queue.Interface.Queue;

@SuppressWarnings("unchecked")
public class CircularArrayQueue<T> implements Queue<T> {
    protected T[] queue;
    protected int front;
    protected int rear;
    protected int capacity;

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.front = -1;
        this.rear = -1;
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
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
    }

    @Override
    public T poll() throws Exception {
        return pollFirst();
    }

    @Override
    public T pollFirst() throws Exception {
        if (isEmpty()) throw new Exception("Queue Underflow");
        T data = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else front = (front + 1) % capacity;
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
        return front == -1 && rear == -1;
    }

    @Override
    public boolean isFull() {
        return (front == 0 && rear == capacity - 1) || (front > rear && front - rear == 1);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        // System.out.println("Front = " + front);
        // System.out.println("Rear = " + rear);
        if (front == -1 || rear == -1) return "[]";
        StringBuilder str = new StringBuilder("[");
        if (front < rear) {
            for (int i = front; i <= rear; i++) {
                if (i < rear) str.append(queue[i]).append(", ");
                else str.append(queue[i]);
            }
        } else {
            for (int i = front; i < capacity; i++) {
                str.append(queue[i]).append(", ");
            }
            for (int i = 0; i <= rear; i++) {
                if (i < rear) str.append(queue[i]).append(", ");
                else str.append(queue[i]);
            }
        }
        return str.append("]").toString();
    }

    /**
     * Returns a string representation of objects in the actual queue with actual positions in the queue
     * space.
     * <p>
     * Could have used Arrays.toString(queue), but while polling elements, the method does not really replace 
     * the elements to be polled by "null". It, rather, simply updates the front and rear pointers. Hence, using
     * Arrays.toString(queue) would not be sufficient to signify polled spaces in the actual queue.
     * @return a string representation of objects in the actual queue
     */
    public String internal() {
        StringBuilder str = new StringBuilder("[");
        if (front <= rear) {
            for (int i = 0; i < capacity; i++) {
                if (i < front) str.append("null").append(", ");
                else if (i >= front && i <= rear) {
                    if (i < capacity - 1) str.append(queue[i]).append(", ");
                    else str.append(queue[i]);
                } else {
                    if (i < capacity - 1) str.append("null").append(", ");
                    else str.append("null");
                }
            }
        } else {
            for (int i = 0; i <= rear; i++) {
                str.append(queue[i]).append(", ");
            }
            for (int i = rear + 1; i < front; i++) str.append("null, ");
            for (int i = front; i < capacity; i++) {
                if (i < capacity - 1) str.append(queue[i]).append(", ");
                else str.append(queue[i]);
            }
        }
        return str.append("]").toString();
    }
    
}

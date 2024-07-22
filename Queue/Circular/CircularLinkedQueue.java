package Queue.Circular;

import LinkedList.CircularLinkedList;
import LinkedList.Interface.List;
import Queue.Interface.Queue;

public class CircularLinkedQueue<T> implements Queue<T> {

    protected List<T> list;

    public CircularLinkedQueue() {
        this.list = new CircularLinkedList<>();
    }

    @Override
    public void offer(T data) {
        offerLast(data);
    }

    @Override
    public void offerLast(T data) {
        list.add(data);
    }

    @Override
    public T poll() throws Exception {
        return pollFirst();
    }

    @Override
    public T pollFirst() throws Exception {
        if (isEmpty()) throw new Exception("Queue Underflow");
        return list.removeStart();
    }

    @Override
    public T peek() throws Exception {
        return peekFirst();
    }

    @Override
    public T peekFirst() throws Exception {
        if (isEmpty()) throw new Exception("Queue Underflow");
        return list.getHead();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Memory is the limit");
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
    
}

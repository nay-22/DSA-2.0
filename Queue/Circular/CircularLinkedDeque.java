package Queue.Circular;

import Queue.Interface.Dequeue;

public class CircularLinkedDeque<T> extends CircularLinkedQueue<T> implements Dequeue<T> {

    @Override
    public void offerFirst(T data) throws Exception {
        list.addStart(data);
    }

    @Override
    public T pollLast() throws Exception {
        if (isEmpty()) throw new Exception("Queue Underflow");
        return list.removeLast();
    }

    @Override
    public T peekLast() throws Exception {
        if (isEmpty()) throw new Exception("Queue Underflow");
        return list.getTail();
    }
    
}

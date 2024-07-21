package Queue.DoublyEnded;

import Queue.Interface.Dequeue;
import Queue.SinglyEnded.LinkedQueue;

public class LinkedDeque<T> extends LinkedQueue<T> implements Dequeue<T> {

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

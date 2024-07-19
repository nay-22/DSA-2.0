package Queue.Interface;

public interface Dequeue<T> extends Queue<T> {
    /**
     * Inserts an element at the front of the Queue
     * @param data
     */
    void offerFirst(T data);

    /**
     * Retrive the last inserted element from the Queue, while removing it as well
     * @return the last element in the Queue
     */
    T pollLast();

    /**
     * Retrive the last inserted element from the Queue
     * @return return the last element in the Queue
     */
    T peekLast();
}

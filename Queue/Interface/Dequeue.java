package Queue.Interface;

public interface Dequeue<T> extends Queue<T> {
    /**
     * Inserts an element at the front of the Queue
     * @param data
     * @throws Exception 
     */
    void offerFirst(T data) throws Exception;

    /**
     * Retrive the last inserted element from the Queue, while removing it as well
     * @return the last element in the Queue
     * @throws Exception 
     */
    T pollLast() throws Exception;

    /**
     * Retrive the last inserted element from the Queue
     * @return return the last element in the Queue
     * @throws Exception 
     */
    T peekLast() throws Exception;
}

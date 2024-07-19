package Queue.Interface;

public interface Queue<T> {
    /**
     * Inserts an element at the end of the Queue, makes use of the {@link #offerLast()} method
     * @param data
     * @throws Exception 
     */
    void offer(T data) throws Exception;

    /**
     * Inserts an element at the end of the Queue
     * @param data
     * @throws Exception 
     */
    void offerLast(T data) throws Exception;

    /**
     * Retrive the element at the front from the Queue, while removing it as well, makes use of 
     * the {@link #pollFirst} method
     * @return the front element in the Queue
     * @throws Exception 
     */
    T poll() throws Exception;

    /**
     * Retrive the element at the front from the Queue, while removing it as well
     * @return the front element in the Queue
     * @throws Exception 
     */
    T pollFirst() throws Exception;

    /**
     * Retrive the element at the front from the Queue, makes use of 
     * the {@link #pollFirst} method
     * @return the front element in the Queue
     * @throws Exception 
     */
    T peek() throws Exception;

    /**
     * Retrive the element at the front from the Queue, makes use of 
     * @return the front element in the Queue
     * @throws Exception 
     */
    T peekFirst() throws Exception;

    /**
     * Return boolean specifying whether the Queue is Empty or not
     * @return true if Queue is Empty, else false
     */
    boolean isEmpty();

    /**
     * Return boolean specifying whether the Queue is Full or not
     * @return true if Queue is Full, else false
     */
    boolean isFull();

    int size();
}

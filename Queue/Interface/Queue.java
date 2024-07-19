package Queue.Interface;

public interface Queue<T> {
    /**
     * Inserts an element at the end of the Queue, makes use of the {@link #offerLast()} method
     * @param data
     */
    void offer(T data);

    /**
     * Inserts an element at the end of the Queue
     * @param data
     */
    void offerLast(T data);

    /**
     * Retrive the element at the front from the Queue, while removing it as well, makes use of 
     * the {@link #pollFirst} method
     * @return the front element in the Queue
     */
    T poll();

    /**
     * Retrive the element at the front from the Queue, while removing it as well
     * @return the front element in the Queue
     */
    T pollFirst();

    /**
     * Retrive the element at the front from the Queue, makes use of 
     * the {@link #pollFirst} method
     * @return the front element in the Queue
     */
    T peek();

    /**
     * Retrive the element at the front from the Queue, makes use of 
     * @return the front element in the Queue
     */
    T peekFirst();

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
}

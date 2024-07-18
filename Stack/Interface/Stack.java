package Stack.Interface;

public interface Stack<T> {
    void push(T data) throws Exception;
    T pop() throws Exception;
    T peek() throws Exception;
    int size();
    int capacity();
    boolean isEmpty();
    boolean isFull();
}

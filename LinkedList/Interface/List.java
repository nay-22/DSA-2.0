package LinkedList.Interface;

public interface List<T> {
    T getHead();
    T getTail();
    void add(T data);
    void addLast(T data);
    void addStart(T data);
    void addAfter(T data, T after) throws Exception;
    void addBefore(T data, T before) throws Exception;
    boolean remove(T data);
    T removeStart();
    T removeLast();
    T removeAfter(T after) throws Exception;
    T removeBefore(T before) throws Exception;
    int size();
    boolean isEmpty();
}

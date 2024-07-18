package LinkedList.Interface;

public interface List<T> {
    void add(T data);
    void addLast(T data);
    void addStart(T data);
    void addAfter(T data, T after);
    void addBefore(T data, T before);
    boolean remove(T data);
    T removeStart();
    T removeLast();
    T removeAfter(T after);
    T removeBefore(T before);
    int size();
    boolean isEmpty();
}

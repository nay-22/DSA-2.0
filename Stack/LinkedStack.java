package Stack;

import LinkedList.LinkedList;
import LinkedList.Interface.List;
import Stack.Interface.Stack;


public class LinkedStack<T> implements Stack<T> {
    
    List<T> stack = new LinkedList<>();

    @Override
    public void push(T data) throws Exception {
        stack.addLast(data);
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty()) throw new Exception("Stack Underflow");
        return stack.removeLast();
    }

    @Override
    public T peek() throws Exception {
        if (isEmpty()) throw new Exception("Stack Underflow");
        return stack.getTail();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public int capacity() {
        throw new UnsupportedOperationException("Memory is the limit");
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Memory is the limit");
    }

    @Override
    public String toString() {
        return stack.toString();
    }
    
}

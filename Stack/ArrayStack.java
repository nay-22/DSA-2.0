package Stack;

import Stack.Interface.Stack;

public class ArrayStack<T> implements Stack<T> {
    private int capacity;
    private int top;
    private T[] stack;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = (T[]) new Object[capacity];
    }

    @Override
    public void push(T data) throws Exception {
        if (isFull()) throw new Exception("Stack Overflow");
        stack[top++] = data;
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty()) throw new Exception("Stack Underflow");
        T data = stack[top--];
        return data;
    }

    @Override
    public T peek() throws Exception {
        if (isEmpty()) throw new Exception("Stack Underflow");
        return stack[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < top; i++) {
            if (i < top - 1) res.append(stack[i]).append(", ");
            else res.append(stack[i]);
        }
        res.append("]");
        return res.toString();
    }

    @Override
    public int capacity() {
        return capacity;
    }
    
}

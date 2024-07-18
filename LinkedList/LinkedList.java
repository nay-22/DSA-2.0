package LinkedList;

import LinkedList.Interface.List;

public class LinkedList<T> implements List<T> {
    class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    private void addEmpty(T data) {
        head = new Node<T>(data);
        tail = head;
    }

    @Override
    public void add(T data) {
        addLast(data);
    }

    @Override
    public void addLast(T data) {
        if (isEmpty()) {
            addEmpty(data);
            return;
        }
        Node<T> temp = new Node<>(data);
        tail.next = temp;
        temp.prev = tail;
        tail = temp;
        size++;
    }

    @Override
    public void addStart(T data) {
        if (isEmpty()) {
            addEmpty(data);
            return;
        }
        Node<T> temp = new Node<>(data);
        temp.next = head;
        head.prev = temp;
        head = temp;
        size++;
    }

    private Node<T> find(T data) {
        Node<T> ptr = head;
        while (ptr.next != null) {
            if (ptr.data.equals(data)) return ptr;
            ptr = ptr.next;
        }
        return null;
    }

    @Override
    public void addAfter(T data, T after) throws Exception {
        if (isEmpty()) {
            addLast(data);
            return;
        }
        Node<T> node = find(after);
        if (node == null) throw new Exception("Node with given data not found");
        Node<T> temp = node.next;
        node.next = new Node<T>(data);
        node.next.next = temp;
    }

    @Override
    public void addBefore(T data, T before) throws Exception {
        if (isEmpty()) {
            addLast(data);
            return;
        }
        Node<T> node = find(before);
        if (node == null) throw new Exception("Node with given data not found");
        Node<T> temp = node.prev;
        Node<T> newNode = new Node<>(data);
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = node;
        node.prev = newNode;

    }

    @Override
    public boolean remove(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public T removeStart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeStart'");
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    @Override
    public T removeAfter(T after) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAfter'");
    }

    @Override
    public T removeBefore(T before) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeBefore'");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        Node<T> ptr = head;
        StringBuilder str = new StringBuilder("[");
        while (ptr != null) {
            if (ptr.next != null) str.append(ptr.data).append(", ");
            else str.append(ptr.data);
            ptr = ptr.next;
        }
        str.append("]");
        return str.toString();
    }

}

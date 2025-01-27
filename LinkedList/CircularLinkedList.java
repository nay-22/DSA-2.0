package LinkedList;

import LinkedList.Interface.List;

public class CircularLinkedList<T> implements List<T> {

    @SuppressWarnings("hiding")
    class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        
        @Override
        public String toString() {
            return "prev = " + prev.data + ", data = " + data + ", next = " + next.data;
        }
    }

    protected Node<T> head;
    protected Node<T> tail;
    protected int size;

    public CircularLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public T getHead() {
        return head.data;
    }

    @Override
    public T getTail() {
        return tail.data;
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
        tail.next = head;
        head.prev = tail;
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
        head.prev = tail;
        tail.next = head;
        size++;
    }

    private Node<T> find(T data) {
        Node<T> ptr = head;
        while (ptr.next != head) {
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
        Node<T> newNode = new Node<T>(data);
        node.next = newNode;
        newNode.prev = node;
        newNode.next = temp;
        temp.prev = newNode;
        size++;
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
        size++;
    }

    @Override
    public boolean remove(T data) {
        Node<T> toRemove = find(data);
        if (toRemove == null) return false;
        Node<T> prevNode = toRemove.prev;
        Node<T> nextNode = toRemove.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
        return true;
    }

    private T remove(Node<T> toRemove) {
        Node<T> prevNode = toRemove.prev;
        Node<T> nextNode = toRemove.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        return toRemove.data;
    }

    @Override
    public T removeStart() {
        if(isEmpty()) return null;
        Node<T> toRemove = head;
        if (head.next == null && head.prev == null) {
            head = tail = null;
            return toRemove.data;
        } else if (head.next == head.prev) {
            tail.next = tail.prev = null;
            head = tail;
            return toRemove.data;
        }
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
        return toRemove.data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        Node<T> toRemove = tail;
        if (tail.next == null && tail.prev == null) {
            tail = head = null;
            return toRemove.data;
        } else if (tail.next == head && tail.prev == head) {
            tail.next = tail.prev = null;
            head = tail;
            return toRemove.data;
        }
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
        return toRemove.data;
    }

    @Override
    public T removeAfter(T after) throws Exception {
        if (after.equals(tail.data)) return null;
        Node<T> node = find(after);
        if (node == null) throw new Exception("Node with given data not found");
        Node<T> toRemove = node.next;
        if (toRemove.next == null) return removeLast();
        size--;
        return remove(toRemove);
    }

    @Override
    public T removeBefore(T before) throws Exception {
        if (before.equals(head.data)) return null;
        Node<T> node = find(before);
        if (node == null) throw new Exception("Node with given data not found");
        Node<T> toRemove = node.prev;
        if (toRemove.prev == null) return removeStart();
        size--;
        return remove(toRemove);
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
        if (isEmpty()) return "[]";
        StringBuilder str = new StringBuilder("[").append(head.data);
        if (head.next == null) return str.append("]").toString();
        else str.append(", ");
        Node<T> ptr = head.next;
        while (ptr != head) {
            if (ptr != tail) str.append(ptr.data).append(", ");
            else str.append(ptr.data);
            ptr = ptr.next;
        }
        return str.append("]").toString();
    }

    
    
}

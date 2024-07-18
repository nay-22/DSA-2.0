package LinkedList;

import LinkedList.Interface.List;

public class LinkedListRunner {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.addStart(50);
        list.addStart(60);
        System.out.println(list);
    }
}

package LinkedList;

import LinkedList.Interface.List;

public class LinkedListRunner {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new LinkedList<>();
        list.addAfter(10, 0);
        list.add(20);
        list.add(30);
        list.add(40);
        list.addStart(50);
        list.addStart(60);
        System.out.println(list);
        list.addAfter(35, 30);
        list.addBefore(15, 20);
        list.addBefore(70, 10);
        System.out.println(list);
    }
}

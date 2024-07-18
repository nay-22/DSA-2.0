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
        System.out.println(list);
        list.addBefore(15, 20);
        System.out.println(list);
        list.addBefore(70, 10);
        System.out.println(list);
        list.remove(15);
        list.remove(35);
        list.remove(35);
        System.out.println(list);
        System.out.println(list.removeStart());
        System.out.println(list);
        System.out.println(list.removeLast());
        System.out.println(list);
        System.out.println("REMOVE AFTER");
        System.out.println(list.removeAfter(30));
        System.out.println(list);
        System.out.println("REMOVE BEFORE");
        System.out.println(list.removeBefore(50));
        System.out.println(list);
    }
}

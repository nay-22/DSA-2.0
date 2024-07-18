package Stack;

import Stack.Interface.Stack;

public class StackRunner {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new ArrayStack<>(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack);
        stack.push(50);
        stack.push(60);
        System.out.println(stack);
    }
}
package stack;

import java.util.Stack;

public class DeleteMiddleStack {
    public static void delete(Stack<Integer> stack) {
        int size = stack.size();
        int mid = size / 2;
        Stack<Integer> tempStack = new Stack<>();
        for (int i = 0; i < mid; i++) {
            tempStack.push(stack.pop());
        }
        stack.pop();
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack before deletion: " + stack);
        delete(stack);
        System.out.println("Stack after deletion: " + stack);
    }
}

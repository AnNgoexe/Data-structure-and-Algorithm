package datastructure.stack;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public TwoStackQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void enqueue(int element) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(element);
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    public int dequeue() {
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public int front() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}


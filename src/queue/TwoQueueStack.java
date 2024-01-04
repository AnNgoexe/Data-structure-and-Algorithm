package queue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public TwoQueueStack() {
        this.q1 = new LinkedList<Integer>();
        this.q2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        this.q2.add(x);
        while (!this.q1.isEmpty()) {
            this.q2.add(this.q1.remove());
        }
        Queue<Integer> temp = this.q1;
        this.q1 = this.q2;
        this.q2 = temp;
    }

    public int pop() {
        return this.q1.remove();
    }

    public int top() {
        return this.q1.peek();
    }

    public boolean empty() {
        return this.q1.isEmpty();
    }

    public int size() {
        return this.q1.size() + this.q2.size();
    }

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Size of stack: " + stack.size());
        System.out.println("Top element: " + stack.top());
        System.out.println("Pop element: " + stack.pop());
        System.out.println("Is stack empty? " + stack.empty());
    }
}

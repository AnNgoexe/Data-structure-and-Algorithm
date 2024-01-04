package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MaxOperations {
    private Stack<Integer> stack;

    public MaxOperations() {
        this.stack = new Stack<>();
    }

    public void insertOperation(String operation) {
        int number = Integer.parseInt(operation.substring(2));
        if (!this.stack.isEmpty()) {
            this.stack.push(Math.max(stack.peek(), number));
        } else {
            stack.push(number);
        }
    }

    public void removeOperation() {
        if (!this.stack.isEmpty()) {
            this.stack.pop();
        }
    }

    public void getMaxOperation(List<Integer> maxElements) {
        if (!this.stack.isEmpty()) {
            maxElements.add(stack.peek());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of operations: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        MaxOperations maxOperations = new MaxOperations();
        List<Integer> result = new ArrayList<>();
        System.out.println("Enter the operations (1 x, 2, or 3):");
        for (int i = 0; i < n; i++) {
            String operation = scanner.nextLine();
            char type = operation.charAt(0);
            switch (type) {
                case '1':
                    maxOperations.insertOperation(operation);
                    break;
                case '2':
                    maxOperations.removeOperation();
                    break;
                case '3':
                    maxOperations.getMaxOperation(result);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Result:");
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}

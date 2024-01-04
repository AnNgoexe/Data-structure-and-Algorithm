package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Waiter {
    List<Integer> sieveOfEratosthenes() {
        boolean[] isPrime = new boolean[10000 + 1];
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= 10000; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= 10000; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= 10000; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        for (int p = 2; p <= 10000; p++) {
            if (isPrime[p]) {
                primeNumbers.add(p);
            }
        }
        return primeNumbers;
    }

    List<Integer> orderPlates(List<Integer> number, int q) {
        Stack<Integer> stack1 = new Stack<>();
        for (int x : number) {
            stack1.push(x);
        }
        List<Integer> primeNumbers = sieveOfEratosthenes();
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 0;
        while (i != q && !stack1.isEmpty()) {
            Stack<Integer> temp = new Stack<>();
            while (!stack1.isEmpty()) {
                if (stack1.peek() % primeNumbers.get(i) == 0) {
                    stack2.push(stack1.pop());
                } else {
                    temp.push(stack1.pop());
                }
            }
            while (!stack2.isEmpty()) {
                answer.add(stack2.pop());
            }
            i++;
            stack1 = temp;
        }
        while (!stack1.isEmpty()) {
            answer.add(stack1.pop());
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of iterations: ");
        int q = scanner.nextInt();

        List<Integer> number = new ArrayList<>();

        System.out.print("Enter the elements separated by space: ");
        for (int i = 0; i < n; i++) {
            number.add(scanner.nextInt());
        }

        Waiter waiter = new Waiter();
        List<Integer> result = waiter.orderPlates(number, q);

        System.out.println("Result: ");
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
        scanner.close();
    }
}

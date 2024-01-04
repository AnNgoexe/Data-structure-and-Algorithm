package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintNumbers {
    public void print(int size, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);

        queue.add(str1);
        queue.add(str2);
        System.out.print(str1 + " " + str2 + " ");

        while (true) {
            String front = queue.poll();
            if(front.length() == size) break;
            queue.add(front + str1);
            System.out.print(front + str1 + " ");

            queue.add(front + str2);
            System.out.print(front + str2 + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum size of numbers: ");
        int size = scanner.nextInt();
        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int b = scanner.nextInt();
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        printNumbers.print(size, a, b);
    }
}

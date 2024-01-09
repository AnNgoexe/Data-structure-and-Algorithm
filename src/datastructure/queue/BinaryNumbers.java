package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryNumbers {
    public void printBinaryNumbersFrom1ToN(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while (n > 0) {
            String s1 = queue.remove();
            String s2 = s1;
            System.out.print(s1 + " ");

            s1 = s1.concat("0");
            queue.add(s1);

            s2 = s2.concat("1");
            queue.add(s2);

            n--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = scanner.nextInt();
        BinaryNumbers binaryNumbers = new BinaryNumbers();
        binaryNumbers.printBinaryNumbersFrom1ToN(number);
        scanner.close();
    }
}

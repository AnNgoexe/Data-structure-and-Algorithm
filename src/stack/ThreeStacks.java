package stack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/equal-stacks/problem?isFullScreen=true

public class ThreeStacks {
    public boolean check(int sum1, int sum2, int sum3) {
        return sum1 == sum2 && sum2 == sum3;
    }

    public int equalStacks(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (Integer number : list1) {
            sum1 += number;
        }
        for (Integer number : list2) {
            sum2 += number;
        }
        for (Integer number : list3) {
            sum3 += number;
        }
        int i = 0, j = 0, k = 0;
        while (!this.check(sum1, sum2, sum3)) {
            int maxVal = Math.max(sum1, Math.max(sum2, sum3));
            if (sum1 == maxVal) {
                sum1 -= list1.get(i++);
            }
            if (sum2 == maxVal) {
                sum2 -= list2.get(j++);
            }
            if (sum3 == maxVal) {
                sum3 -= list3.get(k++);
            }
            if (i >= list1.size() || j >= list2.size() || k >= list3.size()) {
                return 0;
            }
        }
        return sum1;
    }

    public static void main(String[] args) throws IOException {
        ThreeStacks threeStacks = new ThreeStacks();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of List 1: ");
        int size1 = scanner.nextInt();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            list1.add(scanner.nextInt());
        }

        System.out.println("Enter the size of List 2: ");
        int size2 = scanner.nextInt();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < size2; i++) {
            list2.add(scanner.nextInt());
        }

        System.out.println("Enter the size of List 3: ");
        int size3 = scanner.nextInt();
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < size3; i++) {
            list3.add(scanner.nextInt());
        }

        int result = threeStacks.equalStacks(list1, list2, list3);
        System.out.println("The size of 3 stacks after making equal: " + result);
        scanner.close();
    }
}

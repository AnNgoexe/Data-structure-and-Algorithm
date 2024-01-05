package set;

import java.util.HashSet;
import java.util.Set;

public class NumberSet {
    public void printDistinctNumbers(int[] array) {
        Set<Integer> distinctNumbers = new HashSet<>();

        for (int num : array) {
            distinctNumbers.add(num);
        }

        System.out.println("Distinct numbers in the array:");
        for (int distinctNum : distinctNumbers) {
            System.out.print(distinctNum + " ");
        }
        System.out.println();
        System.out.println("Total distinct numbers: " + distinctNumbers.size());
    }

    public static void main(String[] args) {
        NumberSet numberSet = new NumberSet();
        int[] numbers = {5, 3, 8, 2, 1, 7, 4, 6, 5, 2, 8, 7, 1};
        numberSet.printDistinctNumbers(numbers);
    }
}

package array1d;

import java.util.Arrays;

public class OddEvenCount {
    public void print(int[] array) {
        int oddCount = 0, evenCount = 0;

        for (int number : array) {
            if (number % 2 != 0) {
                oddCount++;
            } else {
                evenCount++;
            }
        }
        System.out.print("The number of odds: " + oddCount);
        System.out.print("\nThe number of evens: " + evenCount);
    }

    public static void main(String[] args) {
        OddEvenCount oddEvenCount = new OddEvenCount();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(array));
        oddEvenCount.print(array);
    }
}

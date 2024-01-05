package sort;

import java.util.Arrays;

public class InsertionSort {
    public void print(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 1; i < n; ++i) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
            }
            numbers[j + 1] = key;
            this.print(numbers);
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] numbers = {20, 18, 3, 15, 1, 2, 10, 8, 9, 7, 6, 0, 23, 4, 5};
        System.out.println("Original array:");
        insertionSort.print(numbers);
        System.out.println("Steps in insertion sort:");
        insertionSort.sort(numbers);
    }
}

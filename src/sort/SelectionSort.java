package sort;

import java.util.Arrays;

public class SelectionSort {
    public void print(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public void sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
            System.out.println(Arrays.toString(numbers));
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] numbers = {20, 18, 3, 15, 1, 2, 10, 8, 9, 7, 6, 0, 23, 4, 5};
        System.out.println("Original array:");
        selectionSort.print(numbers);
        System.out.println("Steps in selection sort:");
        selectionSort.sort(numbers);
    }
}

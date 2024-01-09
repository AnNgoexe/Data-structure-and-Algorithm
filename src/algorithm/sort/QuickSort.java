package algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public void print(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public void sort(int[] numbers) {
        this.quickSort(numbers, 0, numbers.length - 1);
    }

    public void quickSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }
        int x = numbers[right];
        int i = left - 1;
        int j = right;
        while (true) {
            while (numbers[++i] < x) {
                if (i == right) {
                    break;
                }
            }
            while (x < numbers[--j]) {
                if (j == left) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        int temp = numbers[i];
        numbers[i] = numbers[right];
        numbers[right] = temp;
        System.out.println(Arrays.toString(numbers));
        this.quickSort(numbers, left, i - 1);
        this.quickSort(numbers, i + 1, right);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] numbers = {20, 18, 3, 15, 1, 2, 10, 8, 9, 7, 6, 0, 23, 4, 5};
        System.out.println("Original array:");
        quickSort.print(numbers);
        System.out.println("Steps of quick sort:");
        quickSort.sort(numbers);
    }
}

package sort;

import java.util.Arrays;

public class BubbleSort {
    public void print(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public void sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            this.print(numbers);
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] numbers = {20, 18, 3, 15, 1, 2, 10, 8, 9, 7, 6, 0, 23, 4, 5};
        System.out.println("Original array:");
        bubbleSort.print(numbers);
        System.out.println("Steps in bubble sort:");
        bubbleSort.sort(numbers);
    }
}

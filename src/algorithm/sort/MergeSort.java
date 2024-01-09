package algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public void print(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public void sort(int[] numbers) {
        this.mergeSort(numbers, 0, numbers.length - 1);
    }

    public void mergeSort(int[] numbers, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            this.mergeSort(numbers, left, middle);
            this.mergeSort(numbers, middle + 1, right);
            this.merge(numbers, left, middle, right);
            this.print(numbers);
        }
    }

    public void merge(int[] numbers, int left, int middle, int right) {
        int leftLength = middle - left + 1;
        int[] leftArray = new int[leftLength];
        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = numbers[left + i];
        }

        int rightLength = right - middle;
        int[] rightArray = new int[rightLength];
        for (int j = 0; j < rightLength; j++) {
            rightArray[j] = numbers[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                numbers[k] = leftArray[i];
                i++;
            } else {
                numbers[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            numbers[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            numbers[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] numbers = {20, 18, 3, 15, 1, 2, 10, 8, 9, 7, 6, 0, 23, 4, 5};
        System.out.println("Original array:");
        mergeSort.print(numbers);
        System.out.println("Steps of merge sort:");
        mergeSort.sort(numbers);
    }
}

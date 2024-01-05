package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapSort {
    public void sort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        System.out.println(Arrays.toString(array));
//        for (int i = n - 1; i > 0; i--) {
//            int temp = array[0];
//            array[0] = array[i];
//            array[i] = temp;
//            heapify(array, i, 0);
//        }
    }

    public void heapify(int[] array, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }

    public void print(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] numbers = {20, 18, 3, 15, 1, 2, 10, 8, 9, 7, 6, 0, 23, 4, 5};
        System.out.println("Original array:");
        heapSort.print(numbers);
        System.out.println("Steps in bubble sort:");
        heapSort.sort(numbers);
    }
}

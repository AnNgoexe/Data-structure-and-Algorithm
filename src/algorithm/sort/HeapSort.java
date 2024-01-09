package algorithm.sort;

import java.util.Arrays;

public class HeapSort {
    public void heapify(int a[], int size, int i)  {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && a[left] > a[largest])  {
            largest = left;
        }
        if (right < size && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, size, largest);
        }
    }

    void sort(int a[], int size)  {
        for (int i = size / 2 - 1; i >= 0; i--)  {
            heapify(a, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

    public void printArr(int a[], int size)  {
        for (int i = 0; i < size; ++i)  {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String args[]) {
        HeapSort heapSort = new HeapSort();
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int n = a.length;
        System.out.print("Before sorting array elements are - \n");
        heapSort.printArr(a, n);
        heapSort.sort(a, n);
        System.out.print("\nAfter sorting array elements are - \n");
        heapSort.printArr(a, n);
    }
}

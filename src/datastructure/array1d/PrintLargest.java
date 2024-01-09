package datastructure.array1d;

public class PrintLargest {
    public void print3largest(int arr[], int arr_size)
    {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        if (arr_size < 3) {
            System.out.print(" Invalid Input ");
            return;
        }

        for (int i = 0; i < arr_size; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third) {
                third = arr[i];
            }
        }
        System.out.println("Three largest elements are " + first + " " + second + " " + third);
    }

    public static void main(String[] args)
    {
        PrintLargest printLargest = new PrintLargest();
        int arr[] = { 12, 13, 1, 10, 34, 1 };
        int n = arr.length;
        printLargest.print3largest(arr, n);
    }
}

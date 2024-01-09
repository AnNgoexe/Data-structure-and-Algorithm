package datastructure.array1d;

public class FibonacciArray {
    public int[] generateFibonacciArray(int n) {
        int[] fibonacciArray = new int[n];
        if (n >= 1) {
            fibonacciArray[0] = 0;
        }
        if (n >= 2) {
            fibonacciArray[1] = 1;
        }
        for (int i = 2; i < n; ++i) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }
        return fibonacciArray;
    }

    public void printFibonacciArray(int[] fibonacciArray) {
        for (int value : fibonacciArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FibonacciArray fibonacciArray = new FibonacciArray();
        int n = 10;
        int[] result = fibonacciArray.generateFibonacciArray(n);
        System.out.println("Fibonacci Array:");
        fibonacciArray.printFibonacciArray(result);
    }
}

package datastructure.array2d;

public class SwapDiagonalElements {
    public void swap(int[][] array) {
        int N = array.length;

        for (int i = 0; i < N; ++i) {
            if (i != N / 2) {
                int temp = array[i][i];
                array[i][i] = array[i][N - i - 1];
                array[i][N - i - 1] = temp;
            }
        }

        for (int[] ints : array) {
            for (int j = 0; j < N; ++j) {
                System.out.print(" " + ints[j]);
            }
            System.out.println();
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(" " + element);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SwapDiagonalElements swapDiagonalElements = new SwapDiagonalElements();
        int[][] array = {
                {4, 5, 6},
                {1, 2, 3},
                {7, 8, 9}
        };

        System.out.println("Matrix before swapping diagonals:");
        swapDiagonalElements.printMatrix(array);
        System.out.println("Matrix after swapping diagonals:");
        swapDiagonalElements.swap(array);
    }
}

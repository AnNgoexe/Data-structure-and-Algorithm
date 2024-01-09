package datastructure.array2d;

public class MatrixPrinter {
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MatrixPrinter matrixPrinter = new MatrixPrinter();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Matrix:");
        matrixPrinter.printMatrix(matrix);
    }
}

package array2d;

public class MatrixOperations {
    public int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            System.out.println("Invalid matrix dimensions for multiplication");
            return null;
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; ++i) {
            for (int j = 0; j < cols2; ++j) {
                for (int k = 0; k < cols1; ++k) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MatrixOperations matrixOperations = new MatrixOperations();

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Matrix 1:");
        matrixOperations.printMatrix(matrix1);

        int[][] matrix2 = {
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}
        };
        System.out.println("Matrix 2:");
        matrixOperations.printMatrix(matrix2);

        int[][] sumMatrix = matrixOperations.addMatrices(matrix1, matrix2);
        System.out.println("Sum Matrix:");
        matrixOperations.printMatrix(sumMatrix);

        int[][] differenceMatrix = matrixOperations.subtractMatrices(matrix1, matrix2);
        System.out.println("Difference Matrix:");
        matrixOperations.printMatrix(differenceMatrix);


        int[][] productMatrix = matrixOperations.multiplyMatrices(matrix1, matrix2);
        System.out.println("Product Matrix:");
        matrixOperations.printMatrix(productMatrix);
    }
}

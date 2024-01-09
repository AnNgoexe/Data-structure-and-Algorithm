package datastructure.array2d;

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TransposeMatrix transposeMatrix = new TransposeMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] transposedMatrix = transposeMatrix.transpose(matrix);
        System.out.println("Original Matrix:");
        transposeMatrix.printMatrix(matrix);

        System.out.println("Transposed Matrix:");
        transposeMatrix.printMatrix(transposedMatrix);
    }
}

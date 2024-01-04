package array2d;

public class DiagonalSum {
    public int calculateDiagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - i - 1];
        }

        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
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
        DiagonalSum diagonalSum = new DiagonalSum();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Matrix:");
        diagonalSum.printMatrix(matrix);

        int sum = diagonalSum.calculateDiagonalSum(matrix);
        System.out.println("Sum of the main diagonal: " + sum);
    }
}

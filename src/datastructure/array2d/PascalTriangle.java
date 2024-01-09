package datastructure.array2d;

import java.util.Scanner;

public class PascalTriangle {
    public int[][] generatePascalTriangle(int numRows) {
        int[][] triangle = new int[numRows][];

        for (int i = 0; i < numRows; ++i) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            for (int j = 1; j < i; ++j) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
            triangle[i][i] = 1;
        }
        return triangle;
    }

    public void printPascalTriangle(int[][] triangle) {
        int numRows = triangle.length;
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int numRows = scanner.nextInt();
        int[][] triangle = pascalTriangle.generatePascalTriangle(numRows);
        System.out.println("Pascal Triangle:");
        pascalTriangle.printPascalTriangle(triangle);
    }
}

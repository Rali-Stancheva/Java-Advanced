package ADVANCED.EXERCISE2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P3_Diagonal_Difference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensions = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[dimensions][dimensions];
        for (int r = 0; r < dimensions; r++) {
            int[] lines = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = lines;
        }

        int firstDiagonalSum = primaryDiagonal(matrix);
        int secondDiagonalSum = secondaryDiagonal(matrix);
        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));

    }

    private static int primaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[1].length; c++) {
                if (matrix[r] == matrix[c]) {
                    sum = sum + matrix[r][c];
                }
            }
        }
        return sum;
    }

    private static int secondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[1].length; c++) {
                if (c == matrix.length - r - 1){
                    sum = sum + matrix[r][c];
                }
            }
        }
        return sum;
    }
}

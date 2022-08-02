package ADVANCED.LAB2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P5_Maximum_Sum_of_2x2_Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            int[] element = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = element;
        }

        int maxValue = Integer.MIN_VALUE;
        int[][] subMatrix = new int[2][2];

        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < cols - 1; c++) {
                int sum = matrix[r][c] + matrix[r][c + 1] + matrix[r + 1][c] + matrix[r + 1][c + 1];
                if (sum > maxValue){
                    maxValue = sum;

                    subMatrix[0][0] = matrix[r][c];
                    subMatrix[0][1] = matrix[r][c + 1];
                    subMatrix[1][0] = matrix[r + 1][c];
                    subMatrix[1][1] = matrix[r + 1][c + 1];
;                }
            }
        }

        for (int r = 0; r < subMatrix.length; r++) {
            for (int c = 0; c < subMatrix[1].length; c++) {
                System.out.print(subMatrix[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println(maxValue);
    }
}

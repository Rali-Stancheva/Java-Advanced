package ADVANCED.LAB2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P6_Print_Diagonals_of_Square_Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];

        for (int r = 0; r < n; r++) {
            int[] element = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = element;
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r] == matrix[c]){
                    System.out.print(matrix[r][c] + " ");
                }
            }
        }
        System.out.println();

            for (int c = 0; c < n; c++) {
                System.out.print(matrix[n - 1 - c][c] + " ");
            }
    }
}


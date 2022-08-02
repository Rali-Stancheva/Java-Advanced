package ADVANCED.LAB2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P4_Sum_Matrix_Elements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];


        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = elements;
        }

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}

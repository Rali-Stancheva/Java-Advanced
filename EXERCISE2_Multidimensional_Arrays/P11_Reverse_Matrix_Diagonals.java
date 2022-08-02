package ADVANCED.EXERCISE2_Multidimensional_Arrays;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class P11_Reverse_Matrix_Diagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            int[] element = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = element;
        }

        int row = rows - 1;
        int col = cols - 1;

        while (row != -1){
            int r = row;
            int c = col;
            while (c<cols && r >=0){
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == -1){
                col = 0;
                row--;
            }
        }
    }
}

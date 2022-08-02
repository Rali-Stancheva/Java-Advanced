package ADVANCED.LAB2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P1_Compare_Matrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = elements;
        }


        int[] dimensions2 = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows2 = dimensions2[0];
        int cols2 = dimensions2[1];

        int[][] matrix2 = new int[rows2][cols2];
        for (int row = 0; row < rows2; row++) {
            int[] elements = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix2[row] = elements;
        }


        if (!isEqual(matrix,matrix2)){
            System.out.println("not equal");
        } else {
            System.out.println("equal");
        }
    }

    private static boolean isEqual(int[][] matrix, int[][] matrix2) {
        if (matrix.length != matrix2.length) {
            return false;
        }

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row].length != matrix2[row].length){
                return  false;
            }
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != matrix2[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}

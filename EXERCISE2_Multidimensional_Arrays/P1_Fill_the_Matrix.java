package ADVANCED.EXERCISE2_Multidimensional_Arrays;

import java.util.Scanner;

public class P1_Fill_the_Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        int dimensions = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[dimensions][dimensions];
        if (pattern.equals("A")){
            patternA(matrix);
        }else if (pattern.equals("B")){
            patternB(matrix);
        }

        printMatrix(matrix);
    }

    private static void patternA(int[][] matrix) {
        int startNum = 1;
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix[1].length; r++) {
               matrix[r][c] = startNum;
               startNum++;
            }
        }
    }

    private static void patternB(int[][] matrix) {
        int startNum = 1;
        for (int c = 0; c < matrix.length; c++) {
          if (c % 2 == 0){
              for (int r = 0; r < matrix[1].length; r++) {
                  matrix[r][c] = startNum;
                  startNum++;
              }
          } else {
              for (int r = matrix[1].length - 1; r >= 0; r--) {
                  matrix[r][c] = startNum;
                  startNum++;
              }
          }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[1].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}

package ADVANCED.EXERCISE2_Multidimensional_Arrays;

import java.util.Scanner;

public class P2_Matrix_of_Palindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();

        String[][] matrix = new String[rows][cols];

        char startSymbol = 'a';
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String palindrome = "" + startSymbol + (char)(startSymbol + c) + startSymbol;
                matrix[r][c] = palindrome;
            }
            startSymbol = (char)(startSymbol + 1);
        }
        printMatrix(matrix,rows,cols);
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}

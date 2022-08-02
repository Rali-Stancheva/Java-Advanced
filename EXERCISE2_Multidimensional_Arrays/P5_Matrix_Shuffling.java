package ADVANCED.EXERCISE2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P5_Matrix_Shuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scan);

        String command = scan.nextLine();
        while (!command.equals("END")) {

            if (!validateCommand(command, rows, cols)) {
                System.out.println("Invalid input!");
            } else{
                String[] commandsData = command.split("\\s+");
                int row1 = Integer.parseInt(commandsData[1]);
                int col1 = Integer.parseInt(commandsData[2]);
                int row2 = Integer.parseInt(commandsData[3]);
                int col2 = Integer.parseInt(commandsData[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row2][col2] = firstElement;
                matrix[row1][col1] = secondElement;

                printMatrix(matrix, rows, cols);
            }
            command = scan.nextLine();
        }

    }
    private static void fillMatrix(String[][] matrix, Scanner scan) {
        for (int r = 0; r < matrix.length; r++) {
            String[] intRows = scan.nextLine().split("\\s+");
            matrix[r] = intRows;
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean validateCommand(String command, int rows, int cols) {
        String[] commandsData = command.split("\\s+");
        String swap = commandsData[0];

        if (commandsData.length != 5) {
            return false;
        }
        if (!swap.equals("swap")) {
            return false;
        }

        int row1 = Integer.parseInt(commandsData[1]);
        int col1 = Integer.parseInt(commandsData[2]);
        int row2 = Integer.parseInt(commandsData[3]);
        int col2 = Integer.parseInt(commandsData[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }
        return true;
    }
}

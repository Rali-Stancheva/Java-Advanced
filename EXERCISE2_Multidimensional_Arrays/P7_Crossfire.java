package ADVANCED.EXERCISE2_Multidimensional_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P7_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //вход
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];


        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int[] rowColRadius = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray(); // 3 4 1
            int row = rowColRadius[0];
            int col = rowColRadius[1]; //индексът на елемента в листа
            int radius = rowColRadius[2];

            //destroy up, down
            for (int currentRow = row - radius; currentRow <= row + radius ; currentRow++) {
                if(isInMatrix(currentRow, col, matrix) && currentRow != row) { //валидираме реда от който ще вземем
                    matrix.get(currentRow).remove(col);
                }
            }

            //destroy left. right
            for (int currentColumn = col + radius; currentColumn >= col - radius; currentColumn--) {
                if(isInMatrix(row, currentColumn, matrix)) { //валидираме колоната от който ще вземем
                    matrix.get(row).remove(currentColumn);
                }
            }

            matrix.removeIf(List::isEmpty);
            command = scanner.nextLine();

        }

        printMatrix(matrix);
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }


    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(number++);
            }
        }
    }


    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row ) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

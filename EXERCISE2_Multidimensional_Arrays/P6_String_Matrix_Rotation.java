package ADVANCED.EXERCISE2_Multidimensional_Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P6_String_Matrix_Rotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rotation = scan.nextLine();
        int angleRotation = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        List<String> lineForMatrix = new ArrayList<>();
        int maxLength = 0;
        while (true) {
            String line = scan.nextLine();
            if (line.equals("END")) {
                break;
            }

            lineForMatrix.add(line);
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }
        int rows = lineForMatrix.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        //пълним матрицата
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (c < lineForMatrix.get(r).length()) {
                    matrix[r][c] = lineForMatrix.get(r).charAt(c);
                } else {
                    matrix[r][c] = ' ';
                }
            }
        }
        rotate(angleRotation, rows, cols, matrix);
    }

    private static void rotate(int angleRotation, int rows, int cols, char[][] matrix) {
        if (angleRotation == 90) {
            for (int c = 0; c < cols; c++) {
                for (int r = rows - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }

        } else if (angleRotation == 180) {
            for (int r = rows - 1; r >= 0; r--) {
                for (int c = cols - 1; c >= 0; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }

        } else if (angleRotation == 270) {
            for (int c = cols - 1; c >= 0; c--) {
                for (int r = 0; r < rows ; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }

        } else {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }
    }
}

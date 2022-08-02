package ADVANCED.EXAMS.EXAM_18August2021_Retake;

import java.util.Scanner;

public class P2_variant2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(scanner, matrix);

        //P -> позиция на играча
        //F -> финал
        //B -> бонус
        //T -> капан

        //първоначална позиция на играча
        int rowPlayer = 0;
        int colPlayer = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                char currPosition = matrix[r][c];
                if (currPosition == 'P') {
                    rowPlayer = r;
                    colPlayer = c;
                    break;
                }
            }
        }

        boolean hasWon = false;
        for (int i = 1; i <= countCommands; i++) {
            String direction = scanner.nextLine();

            int newRow = 0;
            int newCol = 0;

            switch (direction) {
                case "up":
                    //row - 1
                    newRow = checkIsOutside(rowPlayer - 1, size);
                    newCol = checkIsOutside(colPlayer, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer - 2, size);
                        newCol = checkIsOutside(colPlayer, size);
                    }
                    break;
                case "down":
                    //row + 1
                    newRow = checkIsOutside(rowPlayer + 1, size);
                    newCol = checkIsOutside(colPlayer, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer + 2, size);
                        newCol = checkIsOutside(colPlayer, size);
                    }
                    break;
                case "left":
                    //col - 1
                    newRow = checkIsOutside(rowPlayer, size);
                    newCol = checkIsOutside(colPlayer - 1, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer, size);
                        newCol = checkIsOutside(colPlayer - 2, size);
                    }
                    break;
                case "right":
                    //col + 1
                    newRow = checkIsOutside(rowPlayer, size);
                    newCol = checkIsOutside(colPlayer + 1, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer, size);
                        newCol = checkIsOutside(colPlayer + 2, size);
                    }
                    break;
            }

            if (matrix[newRow][newCol] == 'T') {
                newRow = rowPlayer;
                newCol = colPlayer;
            } else {
                if (matrix[newRow][newCol] == 'F') {
                    hasWon = true;
                }
                matrix[rowPlayer][colPlayer] = '.';
                matrix[newRow][newCol] = 'P';
                rowPlayer = newRow;
                colPlayer = newCol;
            }
        }

        if (hasWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);
    }


    private static int checkIsOutside(int value, int size) {
        //ако е вътре в матрицата ред или колона -> връщам стойността
        //ако е извън -> връщаме новата стойност
        if (value < 0) {
            value = size - 1;
        } else if (value >= size){
            value = 0;
        }
        return value;
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[1].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}

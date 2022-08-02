package ADVANCED.EXAMS.EXAM_18August2021_Retake;

import java.util.Scanner;

public class P2_Formula_One {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int countCommands = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[size][size];

        int playerRow = 0;
        int playerCol = 0;

        for (int r = 0; r < size; r++) {
            String[] input = scan.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = input[c];

                if (matrix[r][c].equals("P")) {
                    playerRow = r;
                    playerCol = c;
                }
            }
        }

        boolean hasWon = false;

        for (int i = 1; i <= countCommands; i++) {
            String direction = scan.nextLine();

            int newRow = 0;
            int newCol = 0;

            switch (direction) {
                case "up":
                    //newRow-1;
                    newRow = checkIsOutside(playerRow - 1, size);
                    newCol = checkIsOutside(playerCol, size);
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = checkIsOutside(playerRow - 2, size);
                        newCol = checkIsOutside(playerCol, size);
                    }
                    break;
                case "down":
                    //newRow+1;
                    newRow = checkIsOutside(playerRow + 1, size);
                    newCol = checkIsOutside(playerCol, size);
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = checkIsOutside(playerRow + 2, size);
                        newCol = checkIsOutside(playerCol, size);
                    }
                    break;
                case "left":
                    //newCol-1;
                    newRow = checkIsOutside(playerRow, size);
                    newCol = checkIsOutside(playerCol - 1, size);
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = checkIsOutside(playerRow, size);
                        newCol = checkIsOutside(playerCol - 2, size);
                    }
                    break;
                case "right":
                    //newCol+1;
                    newRow = checkIsOutside(playerRow, size);
                    newCol = checkIsOutside(playerCol + 1, size);
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = checkIsOutside(playerRow, size);
                        newCol = checkIsOutside(playerCol + 2, size);
                    }
                    break;
            }

            if (matrix[newRow][newCol].equals("T")){
                newRow = playerRow;
                newCol = playerCol;
            } else {
                if (matrix[newRow][newCol].equals("F")){
                    hasWon = true;
                }
                matrix[playerRow][playerCol] = ".";
                matrix[newRow][newCol] = "P";
                playerRow = newRow;
                playerCol = newCol;
            }
        }
        if (hasWon){
            System.out.println("Well done, the player won first place!");
        }else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    public static int checkIsOutside(int value, int size) {
        if (value < 0) {
            value = size - 1;
        } else if (value >= size){
            value = 0;
        }
        return value;
    }
}

package ADVANCED.EXAMS.EXAM_22_Feb_2020;

import java.util.Scanner;

public class P2_Re_Volt {
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

                if (matrix[r][c].equals("f")) {
                    playerRow = r;
                    playerCol = c;
                }
            }
        }

        boolean isEnd = false;

        for (int i = 0; i < countCommands; i++) {
            int oldRow = playerRow;
            int oldCol = playerCol;
            matrix[oldRow][oldCol] = "-";

            String command = scan.nextLine();
            switch (command) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }

            if (playerRow < 0 || playerRow >= size) {
                if (playerRow < 0) {
                    playerRow = matrix.length - 1;
                }
                if (playerRow >= size) {
                    playerRow = 0;
                }
            }

            if (playerCol < 0 || playerCol >= size) {
                if (playerCol < 0) {
                    playerCol = matrix.length - 1;
                }
                if (playerCol >= size) {
                    playerCol = 0;
                }
            }
            // f t b
            if (matrix[playerRow][playerCol].equals("F")) {
                matrix[playerRow][playerCol] = "f";
                isEnd = true;
                break;
            }
            if (matrix[playerRow][playerCol].equals("T")) {
                playerRow = oldRow;
                playerCol = oldCol;
            } else if (matrix[playerRow][playerCol].equals("B")) {
                if (playerRow > 0 && playerRow <= matrix.length - 1 && playerCol > 0 && playerCol <= matrix.length - 1){
                    switch (command) {
                        case "up":
                            playerRow--;
                            break;
                        case "down":
                            playerRow++;
                            break;
                        case "left":
                            playerCol--;
                            break;
                        case "right":
                            playerCol++;
                            break;
                    }
                } else {
                    switch (command) {
                        case "up":
                            playerRow = matrix.length - 1;
                            break;
                        case "down":
                            playerRow = 0;
                            break;
                        case "left":
                            playerCol = matrix.length - 1;
                            break;
                        case "right":
                            playerCol = 0;
                            break;
                    }
                }
            }

            matrix[playerRow][playerCol] = "f";
        }


        if (isEnd) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(size, matrix);
    }


    private static void printMatrix(int n, String[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}

package ADVANCED.EXAMS.ЕXAM_28_June_2020;

import java.util.Scanner;

public class Snake_Eli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        int snakeRow = 0;
        int snakeCol = 0;

        int firstLairRow = 0;
        int firstLairCol = 0;

        int secondLairRow = 0;
        int secondLairCol = 0;

        boolean isFirstLair = false;

        for (int r = 0; r < size; r++) {
            String[] rowInput = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = rowInput[c];

                if (matrix[r][c].equals("S")) {
                    snakeRow = r;
                    snakeCol = c;
                }

                if (matrix[r][c].equals("B") && !isFirstLair) {
                    firstLairRow = r;
                    firstLairCol = c;
                    isFirstLair = true;
                }

                if (matrix[r][c].equals("B") && isFirstLair) {
                    secondLairRow = r;
                    secondLairCol = c;
                }
            }
        }

        boolean gameOver = false;
        int food = 0;
        while (true) {
            matrix[snakeRow][snakeCol] = ".";

            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }

            if (snakeRow < 0 || snakeRow >= matrix.length || snakeCol < 0 || snakeCol >= matrix.length){
                gameOver = true;
                break;
            }
            if (matrix[snakeRow][snakeCol].equals("*")) {
                food++;
            } else if (snakeRow == firstLairRow && snakeCol == firstLairCol) {
                snakeRow = secondLairRow;
                snakeCol = secondLairCol;
                matrix[firstLairRow][firstLairCol] = ".";
            } else if (snakeRow == secondLairRow && snakeCol == secondLairCol) {
                snakeRow = firstLairRow;
                snakeCol = firstLairCol;
                matrix[secondLairRow][secondLairCol] = ".";
            }

            if(food >= 10){
                matrix[snakeRow][snakeCol] = "S";
                break;
            }
        }
        if (gameOver){
            System.out.println("Game over!");
        }
        if (food >= 10){
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + food);
        print(matrix);
    }

    private static void print(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}

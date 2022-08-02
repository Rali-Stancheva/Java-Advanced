package ADVANCED.EXAMS.EXAM_26_June_2021;

import java.util.Scanner;

public class P2_Python {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        String[] commands = scan.nextLine().split(", ");


        String[][] matrix = new String[size][size];

        int pythonLen = 1;
        int countFood = 0;

        int pythonRow = 0;
        int pythonCol = 0;

        for (int r = 0; r < size; r++) {
            String[] input = scan.nextLine().split("\\s+");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = input[c];

                if (matrix[r][c].equals("s")) {
                    pythonRow = r;
                    pythonCol = c;
                }
                if (matrix[r][c].equals("f")) {
                    countFood++;
                }
            }
        }

        boolean isDead = false;

        for (String command : commands) {
            matrix[pythonRow][pythonCol] = "*";
            switch (command) {
                case "up":
                    pythonRow--;
                    break;
                case "down":
                    pythonRow++;
                    break;
                case "left":
                    pythonCol--;
                    break;
                case "right":
                    pythonCol++;
                    break;
            }

            if (pythonRow < 0 || pythonRow >= size) {
                if (pythonRow < 0) {
                    pythonRow = matrix.length - 1;
                }
                if (pythonRow >= size) {
                    pythonRow = 0;
                }
            }

            if (pythonCol < 0 || pythonCol >= size) {
                if (pythonCol < 0) {
                    pythonCol = matrix.length - 1;
                }
                if (pythonCol >= size) {
                    pythonCol = 0;
                }
            }

            if (matrix[pythonRow][pythonCol].equals("f")) {
                pythonLen++;
                countFood--;
            }

            if (matrix[pythonRow][pythonCol].equals("e")) {
                isDead = true;
                break;
            }

            if (countFood == 0) {
                break;
            }
        }


        if (isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (countFood == 0) {
            System.out.printf("You win! Final python length is %s", pythonLen);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", countFood);
        }

    }
}

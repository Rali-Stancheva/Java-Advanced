package ADVANCED.EXAMS.EXAM_19_August_2020_Retake;

import java.util.Scanner;

public class P2_Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[size][size];

        int beeRow = 0;
        int beeCol = 0;

        for (int r = 0; r < size; r++) {
            String[] input = scan.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = input[c];

                if (matrix[r][c].equals("B")) {
                    beeRow = r;
                    beeCol = c;
                }
            }
        }

        int pollinatedFlower = 0;

        String commands = scan.nextLine();
        while (!commands.equals("End")) {
            matrix[beeRow][beeCol] = ".";

            switch (commands) {
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
            }

            if (beeCol < 0 || beeCol >= size || beeRow < 0 || beeRow >= size) {
                System.out.println("The bee got lost!");
                break;
            }

            if (matrix[beeRow][beeCol].equals("f")) {
                pollinatedFlower++;
            } else if (matrix[beeRow][beeCol].equals("O")) {
                continue;
            }

            matrix[beeRow][beeCol] = "B";
            commands = scan.nextLine();
        }

        if (pollinatedFlower >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!",pollinatedFlower);
        }else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more",5 - pollinatedFlower);
        }

        printMatrix(size,matrix);
    }
    private static void printMatrix(int n, String[][] matrix) {
       System.out.println();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}

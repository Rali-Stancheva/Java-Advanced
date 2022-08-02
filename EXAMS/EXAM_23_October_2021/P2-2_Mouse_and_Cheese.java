package ADVANCED.EXAMS.EXAM_23_October_2021;

import java.util.Scanner;

public class vbcvn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRows = Integer.parseInt(scanner.nextLine());

        int mouseRow = -1;
        int mouseCol = -1;

        String[][] mouseLabirint = readMatrix(numRows, scanner);

        for (int row = 0; row < mouseLabirint.length; row++) {
            boolean stop = false;
            for (int col = 0; col < mouseLabirint[row].length; col++) {
                if (mouseLabirint[row][col].equals("M")) {
                    mouseRow = row;
                    mouseCol = col;
                    stop = true;
                }
            }
            if (stop) {
                break;
            }
        }
        boolean endGame = false;
        int numCheeses = 0;

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {

                case "up":
                    if (mouseRow - 1 < 0) {
                        mouseLabirint[mouseRow][mouseCol] = "-";
                        endGame = true;
                        break;
                    } else {
                        mouseLabirint[mouseRow][mouseCol] = "-";
                        mouseRow--;
                        if (mouseLabirint[mouseRow][mouseCol].equals("c")) {
                            numCheeses++;
                            mouseLabirint[mouseRow][mouseCol] = "M";
                        } else if (mouseLabirint[mouseRow][mouseCol].equals("B")) {
                            if (mouseRow - 1 <0) {
                                mouseLabirint[mouseRow][mouseCol] = "-";
                                endGame = true;
                                break;
                            } else {
                                mouseLabirint[mouseRow][mouseCol] = "-";
                                mouseRow--;
                                if (mouseLabirint[mouseRow][mouseCol].equals("c")){
                                    numCheeses++;
                                }
                                mouseLabirint[mouseRow][mouseCol] = "M";
                            }
                        } else {
                            mouseLabirint[mouseRow][mouseCol] = "M";
                        }
                    }
                    break;


                case "down":
                    if (mouseRow + 1 >= mouseLabirint.length) {
                        mouseLabirint[mouseRow][mouseCol] = "-";
                        endGame = true;
                        break;
                    } else {
                        mouseLabirint[mouseRow][mouseCol] = "-";
                        mouseRow++;
                        if (mouseLabirint[mouseRow][mouseCol].equals("c")) {
                            numCheeses++;
                            mouseLabirint[mouseRow][mouseCol] = "M";
                        } else if (mouseLabirint[mouseRow][mouseCol].equals("B")) {
                            if (mouseRow+ 1 >= mouseLabirint.length) {
                                mouseLabirint[mouseRow][mouseCol] = "-";
                                endGame = true;
                            } else {
                                mouseLabirint[mouseRow][mouseCol] = "-";
                                mouseRow++;
                                if (mouseLabirint[mouseRow][mouseCol].equals("c")){
                                    numCheeses++;
                                }
                                mouseLabirint[mouseRow][mouseCol] = "M";
                            }
                        } else {
                            mouseLabirint[mouseRow][mouseCol] = "M";
                        }
                    }
                    break;


                case "left":
                    if (mouseCol - 1 < 0) {
                        mouseLabirint[mouseRow][mouseCol] = "-";
                        endGame = true;
                    } else {
                        mouseLabirint[mouseRow][mouseCol] = "-";
                        mouseCol--;
                        if (mouseLabirint[mouseRow][mouseCol].equals("c")) {
                            numCheeses++;
                            mouseLabirint[mouseRow][mouseCol] = "M";
                        } else if (mouseLabirint[mouseRow][mouseCol].equals("B")) {
                            if (mouseCol - 1< 0) {
                                mouseLabirint[mouseRow][mouseCol] = "-";
                                endGame = true;
                            } else {
                                mouseLabirint[mouseRow][mouseCol] = "-";
                                mouseCol--;
                                if (mouseLabirint[mouseRow][mouseCol].equals("c")){
                                    numCheeses++;
                                }
                                mouseLabirint[mouseRow][mouseCol] = "M";
                            }
                        } else {
                            mouseLabirint[mouseRow][mouseCol] = "M";
                        }
                    }
                    break;
                case "right":
                    if (mouseCol + 1 >= mouseLabirint[mouseRow].length) {
                        mouseLabirint[mouseRow][mouseCol] = "-";
                        endGame = true;
                        break;
                    } else {
                        mouseLabirint[mouseRow][mouseCol] = "-";
                        mouseCol++;
                        if (mouseLabirint[mouseRow][mouseCol].equals("c")) {
                            numCheeses++;
                            mouseLabirint[mouseRow][mouseCol] = "M";
                        } else if (mouseLabirint[mouseRow][mouseCol].equals("B")) {
                            if (mouseCol + 1 >= mouseLabirint[mouseRow].length) {
                                mouseLabirint[mouseRow][mouseCol] = "-";
                                endGame = true;
                                break;
                            } else {
                                mouseLabirint[mouseRow][mouseCol] = "-";
                                mouseCol++;
                                if (mouseLabirint[mouseRow][mouseCol].equals("c")){
                                    numCheeses++;
                                }
                                mouseLabirint[mouseRow][mouseCol] = "M";
                            }
                        } else {
                            mouseLabirint[mouseRow][mouseCol] = "M";
                        }
                    }
                    break;
            }
            if (endGame){
                break;
            }
            command = scanner.nextLine();
        }

        if (endGame) {
            System.out.printf("Where is the mouse?%n");
        }
        if (numCheeses < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - numCheeses);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", numCheeses);
        }

        for (String[] strings : mouseLabirint) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

    }


    public static String[][] readMatrix(int rows, Scanner scanner) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
        return matrix;
    }
}

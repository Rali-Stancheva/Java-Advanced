package ADVANCED.EXERCISE2_Multidimensional_Arrays;

import java.util.Scanner;

public class P8_The_Heigan_Dance {
    static boolean[][] room = new boolean[15][15];
    static int playerRow = 7, playerCol = 7, playerHP = 18500;
    static double heiganHP = 3000000;
    static String lastAttack = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double damage = Double.parseDouble(scan.nextLine());
        boolean nextTurnPlaque = false;
        while (true) {
            String[] attack = scan.nextLine().split("\\s+");
            heiganHP = heiganHP - damage;

            if (nextTurnPlaque) {
                playerHP = playerHP - 3500;
                nextTurnPlaque = false;
                if (playerIsDead()) {
                    break;
                }
            }
            if (heiganIsDead()) {
                break;
            }
            int row = Integer.parseInt(attack[1]);
            int col = Integer.parseInt(attack[2]);
            splash(row, col);

            switch (attack[0]) {
                case "Cloud": {
                    if (isHit()) {
                        playerHP -= 3500;
                        nextTurnPlaque = true;
                        lastAttack = "Plague Cloud";
                    }
                    break;
                }
                case "Eruption": {
                    if (isHit()) {
                        playerHP -= 6000;
                        lastAttack = "Eruption";
                    }
                    break;
                }
            }
            clear();
            if (playerIsDead()) {
                break;
            }
        }
    }

    private static void clear() {
        for (int r = 0; r < 15; r++) {
            for (int c = 0; c < 15; c++) {
                room[r][c] = false;
            }
        }
    }

    private static boolean isHit() {
        if (room[playerRow][playerCol]) {
            if (playerRow > 0 && playerRow < 15 && !room[playerRow - 1][playerCol]) {
                playerRow--;  //move up
            } else if (playerCol < 14 && !room[playerRow][playerCol + 1]) {
                playerCol++;  // move right
            } else if (playerRow < 14 && !room[playerRow + 1][playerCol]) {
                playerRow++;  // move down
            } else if (playerCol > 0 && playerRow < 15 && !room[playerRow][playerCol - 1]) {
                playerCol--;  // move left
            } else {
                return true;
            }
        }
        return false;
    }

    private static void splash(int row, int col) {
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >= 0 && r < 15 && c >= 0 && c < 15) {
                    room[r][c] = true;
                }
            }
        }
    }

    private static boolean heiganIsDead() {
        if (heiganHP < 0) {
            System.out.println("Heigan: Defeated!");
            if (playerHP < 0) {
                System.out.printf("Player: Killed by %s%n", lastAttack);
            } else {
                System.out.printf("Player: %d%n", playerHP);
            }
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
            return true;
        }
        return false;
    }

    private static boolean playerIsDead() {
        if (playerHP < 0) {
            if (heiganHP < 0) {
                System.out.println("Heigan: Defeated!");
            } else {
                System.out.printf("Heigan: %.2f\n", heiganHP);
            }
            System.out.printf("Player: Killed by %s%n", lastAttack);
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
            return true;
        }
        return false;
    }
}

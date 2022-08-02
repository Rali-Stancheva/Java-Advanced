package ADVANCED.LAB1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P3_Decimal_To_Binary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (num == 0){
            System.out.print(0);
        } else{
            while (num > 0) {
                int rest = num % 2;
                num = num / 2;
                stack.push(rest);
            }
        }

        for (int element : stack) {
            System.out.print(element);
        }
    }
}

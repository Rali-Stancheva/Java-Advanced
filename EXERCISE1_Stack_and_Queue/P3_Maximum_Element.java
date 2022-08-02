package ADVANCED.EXERCISE1_Stack_and_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P3_Maximum_Element {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int[] commands = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int type = commands[0];

            switch (type){
                case 1:
                    int numToPush = commands[1];
                    stack.push(numToPush);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}

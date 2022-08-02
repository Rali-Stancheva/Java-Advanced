package ADVANCED.EXERCISE1_Stack_and_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2_Basic_Stack_Operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] elements = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int toPush = numbers[0];
        int toPop = numbers[1];
        int toCheck = numbers[2];

        for (int i = 0; i < toPush; i++) {
            stack.push(elements[i]);
        }

        for (int i = 0; i < toPop; i++) {
            stack.pop();
        }

        if (stack.contains(toCheck)) {
            System.out.println("true");
        } else {
           if (!stack.isEmpty()){
               System.out.println(Collections.min(stack));
           } else {
               System.out.println(0);
           }
        }
    }
}

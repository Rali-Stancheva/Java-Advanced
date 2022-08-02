package ADVANCED.EXERCISE1_Stack_and_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;

import java.util.Scanner;


public class P1_Reverse_Numbers_with_a_Stack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }

        for (int element : stack) {
            System.out.print(element + " ");
        }
    }
}

package ADVANCED.LAB1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P4_Matching_Brackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '('){
                stack.push(i);
            }else if (ch == ')'){
                int startIndex = stack.pop();
                String contents = input.substring(startIndex,i + 1);
                System.out.println(contents);
            }
        }
    }
}

package ADVANCED.LAB1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1_Browser_History {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String operation = scan.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        String currURL = "";

        while (!operation.equals("Home")) {
            if (operation.equals("back")) {
                if (stack.size() > 1) {
                    stack.pop();
                    currURL = stack.peek();
                    System.out.println(currURL);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                stack.push(operation);
                currURL = stack.peek();
                System.out.println(currURL);
            }
            operation = scan.nextLine();
        }

    }
}

package ADVANCED.LAB1_Stacks_and_Queues;

import java.util.ArrayDeque;;
import java.util.Collections;
import java.util.Scanner;

public class P2_Simple_Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input =scan.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack,input);

        int sum=0;

        while (stack.size() > 1){
            int num1 = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int num2 = Integer.parseInt(stack.pop());

            if (operation.equals("+")){
                sum =num1 + num2;
                String newSum = "" + sum;
                stack.push(newSum);
            }else{
                sum = num1 - num2;
                String newSum = "" + sum;
                stack.push(newSum);
            }
        }
        System.out.println(stack.peek());
    }
}


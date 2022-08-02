package ADVANCED.EXERCISE1_Stack_and_Queue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P5_Balanced_Parentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();

        boolean areBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currBracket = input.charAt(i);

            if (currBracket == '{' || currBracket == '[' || currBracket == '('){
                openBrackets.push(currBracket);
            } else if (currBracket == '}' || currBracket == ']' || currBracket == ')'){
                if (openBrackets.isEmpty()){
                    areBalanced = false;
                    break;
                }

                char last = openBrackets.pop();

                if (last == '{' && currBracket == '}'){
                    areBalanced = true;
                } else if (last == '[' && currBracket == ']'){
                    areBalanced = true;
                }else if (last == '(' && currBracket == ')'){
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }

        if (areBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

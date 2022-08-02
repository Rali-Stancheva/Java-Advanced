package ADVANCED.EXERCISE1_Stack_and_Queue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P7_Simple_Text_Editor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder currText = new StringBuilder();

        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            int command = Integer.parseInt(data[0]);

            switch (command) {
                case 1:
                    stack.push(currText.toString());
                    String text = data[1];
                    currText.append(text);
                    break;
                case 2:
                    stack.push(currText.toString());
                    int count = Integer.parseInt(data[1]);
                    int startIndexToDelete = currText.length() - count;
                    currText.delete(startIndexToDelete,currText.length());
                    break;
                case 3:
                    int index = Integer.parseInt(data[1]);
                    System.out.println(currText.charAt(index - 1));
                    break;
                case 4:
                    if (!stack.isEmpty()){
                        currText = new StringBuilder(stack.pop());
                    }
                    break;
            }
        }
    }
}

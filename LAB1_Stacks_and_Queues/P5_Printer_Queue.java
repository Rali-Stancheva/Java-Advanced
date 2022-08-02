package ADVANCED.LAB1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P5_Printer_Queue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();


        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (queue.size() >= 1){
                    System.out.println("Canceled " + queue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queue.offer(input);
            }
            input = scan.nextLine();
        }
        for (String element : queue) {
            System.out.println(element);

        }
    }
}

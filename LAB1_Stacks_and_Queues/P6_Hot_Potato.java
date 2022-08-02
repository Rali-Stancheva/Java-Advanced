package ADVANCED.LAB1_Stacks_and_Queues;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P6_Hot_Potato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] kids = scan.nextLine().split("\\s+");
        int num = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String element : kids) {
            queue.offer(element);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < num; i++) {
                String currKids = queue.poll();
                queue.offer(currKids);
            }
            System.out.println("Removed " + queue.poll());
        }

        System.out.printf("Last is %s", queue.peek());
    }
}

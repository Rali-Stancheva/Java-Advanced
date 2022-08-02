package ADVANCED.LAB1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P7_Math_Potato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String[] kids = scan.nextLine().split("\\s+");
        int num = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String element : kids) {
            queue.offer(element);
        }

        int cycle = 1;
        /*
        while (queue.size() > 1) {
            for (int i = 1; i < num; i++) {
                String currKids = queue.poll();
                queue.offer(currKids);
            }

            if (){

            }
        }
*/

    }

}

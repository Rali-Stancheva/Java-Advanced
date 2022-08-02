package ADVANCED.EXAMS.EXAM_22_Feb_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Lootbox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        List<Integer> firstBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer box : firstBox) {
            firstBoxQueue.offer(box);
        }

        List<Integer> secondBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer box : secondBox) {
            secondBoxStack.push(box);
        }

        int claimedItems = 0;
        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int currFirstBox = firstBoxQueue.peek();
            int currSecondBox = secondBoxStack.peek();
            int sum = currFirstBox + currSecondBox;

            if (sum % 2 == 0) {
                claimedItems += sum;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            }else {
                int toRemove = secondBoxStack.pop();
                firstBoxQueue.offer(toRemove);
            }
        }

        if (firstBoxQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if (secondBoxStack.isEmpty()){
            System.out.println("Second lootbox is empty");
        }

        if (claimedItems >= 100){
            System.out.printf("Your loot was epic! Value: %d",claimedItems);
        }else {
            System.out.printf("Your loot was poor... Value: %d",claimedItems);
        }
    }
}

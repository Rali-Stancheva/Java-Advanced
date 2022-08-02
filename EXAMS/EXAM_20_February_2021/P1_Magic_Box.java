package ADVANCED.EXAMS.EXAM_20_February_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Magic_Box {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        List<Integer> firstBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer integer : firstBox) {
            firstBoxQueue.offer(integer);
        }

        List<Integer> secondBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer integer : secondBox) {
            secondBoxStack.push(integer);
        }

        int claimedItems = 0;
        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int currFirst = firstBoxQueue.peek();
            int currSecond = secondBoxStack.peek();
            int sum = currFirst + currSecond;

            if (sum % 2 == 0){
                claimedItems += sum;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            }else {
               int toRemove = secondBoxStack.pop();
                firstBoxQueue.offer(toRemove);
            }
        }

        //first line
        if (firstBoxQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        }
        if (secondBoxStack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        //second line
        if (claimedItems >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d",claimedItems);
        }else {
            System.out.printf("Poor prey... Value: %d",claimedItems);
        }

    }
}

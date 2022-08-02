package ADVANCED.EXAMS.EXAM_19_August_2020_Retake;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Flower_Wreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countWreaths = 0;
        int storedFlowers = 0;

        List<Integer> input = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        for (Integer integer : input) {
            liliesStack.push(integer);
        }

        input = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer integer : input) {
            rosesQueue.offer(integer);
        }

        while (liliesStack.size() > 0 && rosesQueue.size() > 0) {
            int lili = liliesStack.peek();
            int rose = rosesQueue.peek();

            if (lili + rose == 15) {
                liliesStack.pop();
                rosesQueue.poll();
                countWreaths++;
            } else if (lili + rose > 15) {
                liliesStack.push(liliesStack.pop() - 2);
            } else if (lili + rose < 15) {
                storedFlowers += rose + lili;
                liliesStack.pop();
                rosesQueue.poll();
            }
        }


        while (storedFlowers > 15) {
            countWreaths++;
            storedFlowers -= 15;
        }


        if (countWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - countWreaths);
        }
    }
}

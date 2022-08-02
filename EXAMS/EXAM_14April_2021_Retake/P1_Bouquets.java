package ADVANCED.EXAMS.EXAM_14April_2021_Retake;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        List<Integer> tulips = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer tulip : tulips) {
            tulipsStack.push(tulip);
        }

        List<Integer> daffodils = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer daffodil : daffodils) {
            daffodilsQueue.offer(daffodil);
        }

        int countBouquet = 0;
        int storedFlower = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int currTulip = tulipsStack.peek();
            int currDaffodil = daffodilsQueue.peek();
            int sum = currTulip + currDaffodil;

            if (sum == 15) {
                countBouquet++;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }
            while (sum > 15) {
                currTulip -= 2; //keep decreasing the value of the tulips by 2
                sum = currTulip + currDaffodil; //update the sum
                tulipsStack.pop();
                tulipsStack.push(currTulip);
            }
            if (sum < 15) {
                storedFlower += sum;  //you have to store them for later
                tulipsStack.pop();
                daffodilsQueue.poll();
            }
        }

        while (storedFlower >= 15) {
            countBouquet++;
            storedFlower -= 15;
        }

        if (countBouquet >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",countBouquet);
        }else {
            System.out.printf("You failed... You need more %d bouquets.",5 - countBouquet);
        }
    }
}

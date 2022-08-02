package ADVANCED.EXAMS.EXAM_15_December2021_Retake;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_2variant {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();

        List<Integer> male = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer integer : male) {
            maleStack.push(integer);
        }


        List<Integer> female = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer integer : female) {
            femaleQueue.offer(integer);
        }

        int countMatch = 0;

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int currMale = maleStack.peek();
            int currFemale = femaleQueue.peek();

            if (currMale <= 0){
                maleStack.pop();
                continue;
            }
            if (currFemale <= 0){
                femaleQueue.poll();
                continue;
            }

            if (currMale % 25 == 0){
                maleStack.pop();
                maleStack.pop();
                continue;
            }
            if (currFemale % 25 == 0){
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            }

            if (currMale == currFemale) {
                countMatch++;
                maleStack.pop();
                femaleQueue.poll();
            } else {
                femaleQueue.poll();
                int toDecrease = maleStack.pop() - 2;
                maleStack.push(toDecrease);
            }
        }

        System.out.printf("Matches: %d\n",countMatch);

        if (maleStack.isEmpty()){
            System.out.println("Males left: none");
        }else {
            System.out.println("Males left: " + maleStack.toString().replaceAll("[\\[\\]]",""));
        }

        if (femaleQueue.isEmpty()){
            System.out.println("Females left: none");
        }else {
            System.out.println("Females left: " + femaleQueue.toString().replaceAll("[\\[\\]]",""));
        }
                
    }
}

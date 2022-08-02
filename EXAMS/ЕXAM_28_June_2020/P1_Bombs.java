package ADVANCED.EXAMS.ЕXAM_28_June_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> effectQueue = new ArrayDeque<>();
        ArrayDeque<Integer> casingStack = new ArrayDeque<>();

        List<Integer> bombEffect = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (Integer integer : bombEffect) {
            effectQueue.offer(integer);
        }
        List<Integer> bombCasing = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (Integer integer : bombCasing) {
            casingStack.push(integer);
        }

        int daturaB = 0;
        int cherryB = 0;
        int smokeDecoyB = 0;

        while (!effectQueue.isEmpty() && !casingStack.isEmpty()) {
            int currEffect = effectQueue.peek();
            int currCasing = casingStack.peek();
            int sum = currEffect + currCasing;

            if (sum == 40){
                daturaB++;
                effectQueue.poll();
                casingStack.pop();
            }else if (sum == 60){
                cherryB++;
                effectQueue.poll();
                casingStack.pop();
            }else  if (sum == 120){
                smokeDecoyB++;
                effectQueue.poll();
                casingStack.pop();
            }else{
                int toDecrease = casingStack.pop() - 5;
                casingStack.push(toDecrease);
            }

            if (daturaB >= 3 && cherryB >= 3 && smokeDecoyB >= 3){
                break;
            }
        }

        //first line
        if (daturaB >= 3 && cherryB >= 3 && smokeDecoyB >= 3){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        //second line
        if (!effectQueue.isEmpty()){
            String output = effectQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bomb Effects: " + output);
        }else{
            System.out.println("Bomb Effects: empty");
        }

        //third line
        if (!casingStack.isEmpty()){
            String output = casingStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bomb Casings: " + output);
        }else{
            System.out.println("Bomb Casings: empty");
        }

        System.out.printf("Cherry Bombs: %d\n",cherryB);
        System.out.printf("Datura Bombs: %d\n",daturaB);
        System.out.printf("Smoke Decoy Bombs: %d",smokeDecoyB);
    }
}

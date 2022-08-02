package ADVANCED.EXAMS.EXAM_18August2021_Retake;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Pastry_shop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] liquids  = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredients  = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        for (int i = 0; i < liquids .length; i++) {
            liquidsQueue.offer(liquids [i]);
        }
        for (int i = 0; i < ingredients .length; i++) {
            ingredientsStack.push(ingredients [i]);
        }

        int biscuitCount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int pieCount = 0;

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int currLiquid = liquidsQueue.peek();
            int currIngredient = ingredientsStack.peek();
            int sum = currLiquid + currIngredient;

            if (sum == 25) {
                biscuitCount++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 50) {
                cakeCount++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 75) {
                pastryCount++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 100) {
                pieCount++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else {
                liquidsQueue.poll();
                int toIncrease = ingredientsStack.pop() + 3;
                ingredientsStack.push(toIncrease);
            }
        }

        //first line
        if (biscuitCount >= 1 && cakeCount >= 1 && pastryCount >= 1 && pieCount >= 1){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else{
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        //second line
        if (liquidsQueue.isEmpty()){
            System.out.println("Liquids left: none");
        }else {
            String output = liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Liquids left: " + output);
        }

        //third line
        if (ingredientsStack.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {
            String output = ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Ingredients left: " + output);
        }

        System.out.printf("Biscuit: %d\n",biscuitCount);
        System.out.printf("Cake: %d\n",cakeCount);
        System.out.printf("Pie: %d\n",pieCount);
        System.out.printf("Pastry: %d",pastryCount);
    }
}

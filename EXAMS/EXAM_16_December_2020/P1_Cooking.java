package ADVANCED.EXAMS.EXAM_16_December_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquidQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();

        List<Integer> liquids = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (Integer element : liquids) {
            liquidQueue.offer(element);
        }

        List<Integer> ingredient = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (Integer element : ingredient) {
            ingredientStack.push(element);
        }

        int breadCount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int fruitPieCount = 0;

        while (!liquidQueue.isEmpty() && !ingredientStack.isEmpty()) {
            int currLiquid = liquidQueue.peek();
            int currIngredient = ingredientStack.peek();
            int sum = currLiquid + currIngredient;

            if (sum == 25) {
                breadCount++;
                liquidQueue.poll();
                ingredientStack.pop();
            } else if (sum == 50) {
                cakeCount++;
                liquidQueue.poll();
                ingredientStack.pop();
            } else if (sum == 75) {
                pastryCount++;
                liquidQueue.poll();
                ingredientStack.pop();
            } else if (sum == 100) {
                fruitPieCount++;
                liquidQueue.poll();
                ingredientStack.pop();
            } else {
                liquidQueue.poll();
                int toIncrease = ingredientStack.pop() + 3;
                ingredientStack.push(toIncrease);
            }
        }

        //first line
        if (breadCount >= 1 && cakeCount >= 1 && pastryCount >= 1 && fruitPieCount >= 1){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        //second line
        if (liquidQueue.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            String output = liquidQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Liquids left: " + output);
        }

        //third line
        if (ingredientStack.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            String output = ingredientStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Ingredients left: " + output);
        }

        System.out.printf("Bread: %d\n",breadCount);
        System.out.printf("Cake: %d\n",cakeCount);
        System.out.printf("Fruit Pie: %d\n",fruitPieCount);
        System.out.printf("Pastry: %d",pastryCount);
    }
}

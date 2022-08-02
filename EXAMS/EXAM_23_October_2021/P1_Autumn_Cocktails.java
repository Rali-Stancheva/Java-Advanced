package ADVANCED.EXAMS.EXAM_23_October_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Autumn_Cocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessLevelStack = new ArrayDeque<>();

        List<Integer> ingredientsList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (Integer ingredients : ingredientsList) {
            ingredientsQueue.offer(ingredients);
        }

        List<Integer> freshnessLevelList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (Integer freshnessLevel : freshnessLevelList) {
            freshnessLevelStack.push(freshnessLevel);
        }

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        while (!ingredientsQueue.isEmpty() && !freshnessLevelStack.isEmpty()) {
            int currIngredients = ingredientsQueue.peek();
            int currFreshnessLevel = freshnessLevelStack.peek();
            int totalFreshness = currIngredients * currFreshnessLevel;

            if (currIngredients == 0) {
                ingredientsQueue.poll();
                continue; //!!!
            }

            if (totalFreshness == 150) {
                pearSour++;
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
            } else if (totalFreshness == 250) {
                theHarvest++;
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
            } else if (totalFreshness == 300) {
                appleHinny++;
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
            } else if (totalFreshness == 400) {
                highFashion++;
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
            } else {
                freshnessLevelStack.pop();
                int toIncrease = ingredientsQueue.poll() + 5;
                ingredientsQueue.offer(toIncrease);
            }
        }


        if (pearSour >= 1 && theHarvest >= 1 && appleHinny >= 1 && highFashion >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int sum = 0;
        if (!ingredientsQueue.isEmpty()) {
            for (Integer currIngr : ingredientsQueue) {
                sum += currIngr;
            }
            System.out.printf("Ingredients left: %d\n", sum);
        }


        if (appleHinny > 0) {
            System.out.printf("# Apple Hinny --> %d\n", appleHinny);
        }
        if (highFashion > 0) {
            System.out.printf("# High Fashion --> %d\n", highFashion);
        }
        if (pearSour > 0) {
            System.out.printf("# Pear Sour --> %d\n", pearSour);
        }
        if (theHarvest > 0) {
            System.out.printf("# The Harvest --> %d\n", theHarvest);
        }


    }
}

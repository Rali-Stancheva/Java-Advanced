package ADVANCED.EXAMS.EXAM_17_Dec_2019_Retake;

import java.util.*;
import java.util.stream.Collectors;

public class P1_Santas_Present_Factory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> numMaterialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();

        List<Integer> numMaterials = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer numMaterial : numMaterials) {
            numMaterialsStack.push(numMaterial);
        }

        List<Integer> magicLevel = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (Integer integer : magicLevel) {
            magicLevelQueue.offer(integer);
        }

        int countPresent = 0;

        int countDoll = 0;
        int countTrain = 0;

        int countBear = 0;
        int countBicycle = 0;


        while (!numMaterialsStack.isEmpty() && !magicLevelQueue.isEmpty()) {
            int currMaterial = numMaterialsStack.peek();
            int currMagicLevel = magicLevelQueue.peek();
            int totalLevel = currMaterial * currMagicLevel;

            if (totalLevel == 150) {
                countDoll++;
                numMaterialsStack.pop();
                magicLevelQueue.poll();
            } else if (totalLevel == 250) {
                countTrain++;
                numMaterialsStack.pop();
                magicLevelQueue.poll();
            } else if (totalLevel == 300) {
                countBear++;
                numMaterialsStack.pop();
                magicLevelQueue.poll();
            } else if (totalLevel == 400) {
                countBicycle++;
                numMaterialsStack.pop();
                magicLevelQueue.poll();
            } else {
                if (totalLevel < 0) {
                    totalLevel = currMaterial + currMagicLevel;
                    numMaterialsStack.pop();
                    magicLevelQueue.poll();
                    numMaterialsStack.push(totalLevel);
                } else if (totalLevel > 0) {
                    magicLevelQueue.poll();
                    int toIncrease = numMaterialsStack.pop() + 15;
                    numMaterialsStack.push(toIncrease);
                } else if (currMagicLevel == 0 || currMaterial == 0) {
                    if (currMagicLevel == 0) {
                        magicLevelQueue.poll();
                    }
                    if (currMaterial == 0) {
                        numMaterialsStack.pop();
                    }
                    if (currMagicLevel == 0 && currMaterial == 0) {
                        magicLevelQueue.poll();
                        numMaterialsStack.pop();
                    }
                }
            }
        }


        //first line
        if ((countDoll > 0 && countTrain > 0) || (countBear > 0 && countBicycle > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }


        //second line
        if (!numMaterialsStack.isEmpty()) {
            String output = numMaterialsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Materials left: " + output);
        }

        if (!magicLevelQueue.isEmpty()) {
            String output = magicLevelQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Magic left: " + output);
        }


        //third line
        if (countBicycle >= 1) {
            System.out.printf("Bicycle: %d\n", countBicycle);
        }

        if (countDoll >= 1) {
            System.out.printf("Doll: %d\n", countDoll);
        }

        if (countBear >= 1) {
            System.out.printf("Teddy bear: %d\n", countBear);
        }

        if (countTrain >= 1) {
            System.out.printf("Wooden train: %d\n", countTrain);
        }

    }
}

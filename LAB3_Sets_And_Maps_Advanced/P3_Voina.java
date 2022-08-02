package ADVANCED.LAB3_Sets_And_Maps_Advanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P3_Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayer = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 1; i <=50; i++) {
            if (firstPlayer.isEmpty()){
                System.out.println("Second player win!");
                return;
            }
            if (secondPlayer.isEmpty()){
                System.out.println("First player win!");
                return;
            }

            int cardFirstPlayer = firstPlayer.iterator().next();  //взимаме си първия елемент
            int cardSecondPlayer = secondPlayer.iterator().next();//взимаме си първия елемент

            firstPlayer.remove(cardFirstPlayer);
            secondPlayer.remove(cardSecondPlayer);

            if (cardFirstPlayer > cardSecondPlayer){
                firstPlayer.add(cardFirstPlayer);
                firstPlayer.add(cardSecondPlayer);
            } else if (cardSecondPlayer > cardFirstPlayer){
                secondPlayer.add(cardFirstPlayer);
                secondPlayer.add(cardSecondPlayer);
            }

        }

        int sizeFirstPlayer = firstPlayer.size();
        int sizeSecondPlayer = secondPlayer.size();

        if (sizeFirstPlayer > sizeSecondPlayer){
            System.out.println("First player win!");
        } else if (sizeSecondPlayer>sizeFirstPlayer){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}

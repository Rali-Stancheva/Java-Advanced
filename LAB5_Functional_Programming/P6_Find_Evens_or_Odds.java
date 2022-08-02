package ADVANCED.LAB5_Functional_Programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P6_Find_Evens_or_Odds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String[] numberBound = scan.nextLine().split("\\s+");
        int firstNum = Integer.parseInt(numberBound[0]);
        int secondNum = Integer.parseInt(numberBound[1]);

        String command = scan.nextLine();

        List<Integer> list = new ArrayList<>();
        for (int i = firstNum; i <= secondNum; i++) {
            list.add(i);
        }

        if (command.equals("even")) {
            List<String> resultEven = list.stream()
                    .filter(e -> e % 2 == 0)
                    .map(e -> e.toString())
                    .collect(Collectors.toList());
            for (String s : resultEven) {
                System.out.print(s + " ");
            }
        } else {
            List<String> resultOdd = list.stream()
                    .filter(e -> e % 2 != 0)
                    .map(e -> e.toString())
                    .collect(Collectors.toList());
            for (String s : resultOdd) {
                System.out.print(s + " ");
            }
        }
    }
}

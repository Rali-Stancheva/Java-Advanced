package ADVANCED.EXERCISE5_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P5_Reverse_And_Exclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());
        Collections.reverse(numberList);

        Predicate<Integer> checkDivision = number -> number % n == 0;
        numberList.removeIf(checkDivision);

        numberList.forEach(number -> System.out.print(number + " "));

    }
}

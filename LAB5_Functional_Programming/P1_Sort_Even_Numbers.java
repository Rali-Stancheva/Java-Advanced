package ADVANCED.LAB5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Sort_Even_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] stringNumbers = scan.nextLine().split(", ");

        // string to INT
        // filter only even numbers
        //sorted
        //int to string
        //print
        List<String> evenNumbersList = Arrays.stream(stringNumbers)
                .map(e -> Integer.parseInt(e))
                .filter(e -> e % 2 == 0)
                .map(e -> e.toString())
                .collect(Collectors.toList());
        System.out.println(String.join(", ", evenNumbersList));


        evenNumbersList = evenNumbersList
                .stream()
                .map(e -> Integer.parseInt(e))
                .filter(e -> e % 2 == 0)
                .sorted()
                .map(e -> e.toString())
                .collect(Collectors.toList());
        System.out.println(String.join(", ", evenNumbersList));
    }
}

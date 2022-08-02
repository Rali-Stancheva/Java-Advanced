package ADVANCED.EXERCISE5_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P1_Consumer_Print {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        Consumer<String> print = name -> System.out.println(name);

        Arrays.stream(input).forEach(print);
    }
}

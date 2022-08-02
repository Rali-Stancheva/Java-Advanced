package ADVANCED.LAB5_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P4_Add_VAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        Function<String,Double> toDouble = e -> Double.parseDouble(e);
        Function<Double,Double> price = e -> e * 1.2;
        Consumer<Double> print = e-> System.out.printf("%.2f\n",e);

        System.out.println("Prices with VAT:");
        Arrays.stream(input)
                .map(toDouble)
                .map(price)
                .forEach(print);
    }
}

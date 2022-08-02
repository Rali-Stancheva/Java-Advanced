package ADVANCED.LAB5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2_Sum_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split(", ");
        Function<String,Integer> func = e -> Integer.parseInt(e); //стринговете от numbers ги правим на интеджери

        List<Integer> list = Arrays.stream(numbers)
                .map(func).collect(Collectors.toList());

        int sum = Arrays.stream(numbers).mapToInt(e -> Integer.parseInt(e)).sum();
        System.out.println("Count = " + list.size());
        System.out.println("Sum = " + sum);
    }
}

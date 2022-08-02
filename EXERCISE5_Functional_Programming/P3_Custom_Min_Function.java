package ADVANCED.EXERCISE5_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P3_Custom_Min_Function {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        //начин 1
        Consumer<List<Integer>> print = list -> System.out.println(Collections.min(numberList));
        print.accept(numberList);

        //начин 2
       // System.out.println(Collections.min(numberList));

        //начин 3
       // Function<List<Integer>,Integer>  func = list -> Collections.min(list);
       // System.out.println(func.apply(numberList));
    }
}

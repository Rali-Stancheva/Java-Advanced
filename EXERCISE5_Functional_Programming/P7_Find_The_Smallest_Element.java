package ADVANCED.EXERCISE5_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P7_Find_The_Smallest_Element {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

      Function<List<Integer>,Integer> func = list -> list.lastIndexOf(Collections.min(list));
        System.out.println(func.apply(numberList));
    }
}

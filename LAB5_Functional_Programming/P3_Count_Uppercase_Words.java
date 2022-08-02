package ADVANCED.LAB5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P3_Count_Uppercase_Words {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Predicate<String> upperCase = word -> Character.isUpperCase(word.charAt(0));
        //Consumer<String> print = System.out::print;

        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(upperCase)
                .collect(Collectors.toList());

        System.out.println(list.size());
       // list.forEach(print);    с Consumer
       for (String s : list) {
            System.out.println(s);
        }
    }
}

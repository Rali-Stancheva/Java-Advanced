package ADVANCED.EXERCISE5_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class P6_Predicate_For_Names {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");

        Arrays.stream(names).filter(name -> name.length() <= n).forEach(System.out::println);
    }
}

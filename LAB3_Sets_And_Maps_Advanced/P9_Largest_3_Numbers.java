package ADVANCED.LAB3_Sets_And_Maps_Advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P9_Largest_3_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .limit(3)
                .forEach(e -> System.out.printf("%d ", e));
    }
}

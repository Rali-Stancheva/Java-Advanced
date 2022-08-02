package ADVANCED.EXERCISE5_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class P2_Knights_of_Honor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        Arrays.stream(input).forEach(e-> System.out.println("Sir " + e));
    }
}

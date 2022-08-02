package ADVANCED.EXERCISE5_Functional_Programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P8_Custom_Comparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = ((first, second) -> {
            if (first % 2 == 0 && second % 2 != 0) {  //първо четно, второ нечетно -> не разменяме
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {   //първо нечетно, второ четно -> размяна
                return 1;
            } else {
              return first.compareTo(second);  //първо четно, второто четно //първи нечетно, второто нечетно
                //first == second -> 0 -> няма размяна
                //first < second -> -1 -> няма размяна
                //first > second -> 1 -> има размяна
            }
        });

        numberList.stream().sorted(comparator).forEach(number -> System.out.print(number + " "));
    }
}

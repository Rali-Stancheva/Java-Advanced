package ADVANCED.EXERCISE5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P4_Applied_Arithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scan.nextLine();

        //add- добава 1 към есеки елемент на листа: приемаме списък -> връюаме списък с модифицирани елементи(аналогично за всички)
        Function<List<Integer>,List<Integer>> add = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
        Function<List<Integer>,List<Integer>> multiply = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
        Function<List<Integer>,List<Integer>> subtract = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(number -> System.out.print(number + " "));

        while (!command.equals("end")){
            switch (command) {
                case "add":
                    numberList = add.apply(numberList);
                    break;
                case "multiply":
                    numberList = multiply.apply(numberList);
                    break;
                case "subtract":
                    numberList = subtract.apply(numberList);
                    break;
                case "print":
                    print.accept(numberList);
                    System.out.println();
                    break;
            }
            command = scan.nextLine();
        }
    }
}

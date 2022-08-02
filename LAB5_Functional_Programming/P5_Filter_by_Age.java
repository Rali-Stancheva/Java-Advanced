package ADVANCED.LAB5_Functional_Programming;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P5_Filter_by_Age {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Integer> personInfo = new LinkedHashMap<>();

        int number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < number; i++) {
            String[] personData = scan.nextLine().split(", ");
            String personName = personData[0];
            int personAge = Integer.parseInt(personData[1]);
            personInfo.put(personName,personAge);
        }

        String comparison = scan.nextLine();
        int ageLimit = Integer.parseInt(scan.nextLine());
        String printType = scan.nextLine();

        BiPredicate<Integer,Integer> filterPredicate;
        if (comparison.equals("younger")){
            filterPredicate = (filterAge,age) -> filterAge <= age;
        }else{
            filterPredicate = (filterAge,age) -> filterAge >= age;
        }

        Consumer<Map.Entry<String,Integer>> print;
        if (printType.equals("age")){
            print = person -> System.out.println(person.getValue());
        } else if (printType.equals("name")){
            print = person -> System.out.println(person.getKey());
        }else{
            print = person -> System.out.printf("%s - %d\n",person.getKey(),person.getValue());
        }


      personInfo.entrySet()
              .stream()
              .filter(person -> filterPredicate.test(person.getValue(),ageLimit))
              .forEach(print);

    }
}

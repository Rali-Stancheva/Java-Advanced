package ADVANCED.EXERCISE6_Defining_Classes.P1_Opinion_Poll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] peopleData = scan.nextLine().split("\\s+");
            String name = peopleData[0];
            int age = Integer.parseInt(peopleData[1]);

            Person person = new Person(name, age);
            if (age > 30) {
                personList.add(person);
            }
        }

        personList.sort(Comparator.comparing(name -> name.getName()));

        for (Person person : personList) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}

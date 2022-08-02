package ADVANCED.LAB3_Sets_And_Maps_Advanced;

import java.util.*;

public class P2_SoftUni_Party {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();
        String command = scan.nextLine();

        while (!command.equals("PARTY")){
            guests.add(command);
            command = scan.nextLine();
        }
        command = scan.nextLine();
        while (!command.equals("END")){
            guests.remove(command);
            command = scan.nextLine();
        }
        System.out.println(guests.size());
        for (String element: guests) {
            System.out.println(element);
        }
    }
}

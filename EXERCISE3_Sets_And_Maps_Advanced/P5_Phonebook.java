package ADVANCED.EXERCISE3_Sets_And_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P5_Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();
        String input = scan.nextLine();

        while (!input.equals("search")) {
            String[] contacts = input.split("-");
            String name = contacts[0];
            String number = contacts[1];

            map.put(name, number);
            input = scan.nextLine();
        }

        String searchName = scan.nextLine();
        while (!searchName.equals("stop")) {
            if (!map.containsKey(searchName)) {
                System.out.printf("Contact %s does not exist.\n", searchName);
            } else {
                System.out.printf("%s -> %s\n", searchName, map.get(searchName));
            }
            searchName = scan.nextLine();
        }
    }
}


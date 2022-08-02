package ADVANCED.EXERCISE3_Sets_And_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P7_Fix_Emails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();
        String input = scan.nextLine();

        while (!input.equals("stop")) {
            String name = input;
            String email = scan.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                map.put(name, email);
            }
            input = scan.nextLine();
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }
    }
}

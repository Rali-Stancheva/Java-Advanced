package ADVANCED.EXERCISE3_Sets_And_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P6_A_Miner_Task {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();


        String input = scan.nextLine();
        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scan.nextLine());

            if (map.containsKey(resource)) {
                int newQuantity = map.get(resource);
                map.put(resource, newQuantity + quantity);
            }else{
                map.put(resource, quantity);
            }
            input = scan.nextLine();
        }

        for (Map.Entry<String, Integer> elements : map.entrySet()) {
            System.out.printf("%s -> %d\n",elements.getKey(),elements.getValue());
        }
    }
}

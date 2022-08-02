package ADVANCED.LAB3_Sets_And_Maps_Advanced;

import java.util.*;

public class P7_Cities_by_Continent_and_Country {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");
            String continents = info[0];
            String country = info[1];
            String cities  = info[2];

          map.putIfAbsent(continents,new LinkedHashMap<>());
          map.get(continents).putIfAbsent(country,new ArrayList<>());
          map.get(continents).get(country).add(cities);
        }

        for (Map.Entry<String,Map<String,List<String>>> entry : map.entrySet()) {
            System.out.printf("%s:\n",entry.getKey());
            for (Map.Entry<String,List<String>> entry2 : entry.getValue().entrySet()) {
                System.out.printf("  %s -> ",entry2.getKey());
                for (String city : entry2.getValue()) {
                    System.out.print(String.join(", ",city));
                }
                System.out.println();
            }
        }
    }
}

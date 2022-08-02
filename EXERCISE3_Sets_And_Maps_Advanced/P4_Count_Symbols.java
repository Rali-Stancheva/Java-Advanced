package ADVANCED.EXERCISE3_Sets_And_Maps_Advanced;

import java.util.*;

public class P4_Count_Symbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Character, Integer> map = new TreeMap<>();
        String input = scan.nextLine();


        for (Character characterEl : input.toCharArray()) {
            if (!map.containsKey(characterEl)) {
                map.put(characterEl, 1);
            } else {
               int element = map.get(characterEl);
               map.put(characterEl,element + 1);
            }
        }
        for (Map.Entry<Character, Integer> element : map.entrySet()) {
            System.out.printf("%s: %d time/s\n",element.getKey(),element.getValue());
        }
    }
}

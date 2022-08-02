package ADVANCED.LAB3_Sets_And_Maps_Advanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P4_Count_Real_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] values = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double,Integer> map = new LinkedHashMap<>();

        for (double elements : values) {
            if (!map.containsKey(elements)){
                map.put(elements,1);
            }else{
                map.put(elements, map.get(elements) + 1);
            }
        }
        for (double print : map.keySet()) {
            System.out.printf("%.1f -> %d\n",print,map.get(print));
        }
    }
}

package ADVANCED.LAB3_Sets_And_Maps_Advanced;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P8_Academy_Graduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String,Double> map = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            double[] grade = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double sum = 0;
            for (int j = 0; j < grade.length; j++) {
                sum = sum + grade[j];
            }
            double avg = sum / grade.length;
            map.put(name,avg);
        }

        map.entrySet().stream().forEach(e ->{
            DecimalFormat curr = new DecimalFormat("0.#####################################");
            System.out.print(e.getKey() + " is graduated with " + curr.format(e.getValue()) + "\n");
        });
    }
}

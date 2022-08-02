package ADVANCED.EXERCISE3_Sets_And_Maps_Advanced;

import java.util.*;

public class P3_Periodic_Table {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> set = new TreeSet<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] chemicalEl = scan.nextLine().split("\\s+");
            set.addAll(Arrays.asList(chemicalEl));
        }
        for (String elements : set) {
            System.out.print(elements + " ");
        }
    }
}

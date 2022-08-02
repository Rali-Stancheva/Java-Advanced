package ADVANCED.EXERCISE3_Sets_And_Maps_Advanced;

import java.util.*;

public class P2_Sets_of_Elements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<>();


        int[] sizeOfSets = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int first = sizeOfSets[0];
        int second = sizeOfSets[1];


        for (int i = 0; i < first; i++) {
            int n = Integer.parseInt(scan.nextLine());
            firstSet.add(n);
        }

        for (int i = 0; i < second; i++) {
            int n = Integer.parseInt(scan.nextLine());
            secondSet.add(n);
        }


        for (Integer integer : firstSet) {
            for (Integer integer1 : secondSet) {
                if (integer.equals(integer1)){
                    list.add(integer1);
                }
            }
        }

        for (int element : list) {
            System.out.print(element + " ");
        }
    }
}

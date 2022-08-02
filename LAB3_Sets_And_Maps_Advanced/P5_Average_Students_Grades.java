package ADVANCED.LAB3_Sets_And_Maps_Advanced;

import java.util.*;

public class P5_Average_Students_Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int students = Integer.parseInt(scan.nextLine());
        Map<String,List<Double>> map = new TreeMap<>();

        for (int i = 0; i < students; i++) {
            String[] studentsInfo = scan.nextLine().split("\\s+");
            String studentName = studentsInfo[0];
            double grade = Double.parseDouble(studentsInfo[1]);

            if (!map.containsKey(studentName)){
                map.put(studentName,new ArrayList<>());
            }
            map.get(studentName).add(grade);
        }

        Map<String,Double> averageMap = new TreeMap<>();
        for (Map.Entry<String,List<Double>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Double> grade = entry.getValue();
            averageMap.put(name,average(grade));
        }


       map.entrySet().stream().forEach(e ->{
           System.out.printf("%s -> ",e.getKey());
           for (double element : e.getValue()) {
               System.out.printf("%.2f ",element);
           }
           System.out.printf("(avg: %.2f)\n",averageMap.get(e.getKey()));
       });

    }
    private static double average (List<Double> grade){
        double sum = 0;
        for (double average : grade) {
            sum = sum + average;
        }
        return sum / grade.size();
    }
}

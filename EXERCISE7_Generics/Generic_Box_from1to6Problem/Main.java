package ADVANCED.EXERCISE7_Generics.Generic_Box_from1to6Problem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        //ЗАДАЧА 1
        /*
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String string = scan.nextLine();
            box.add(string);
        }
        System.out.println(box);
         */


        //ЗАДАЧА 2
        /*
        Box<Integer> box = new Box<>();
        for (int i = 0; i < n; i++) {
            int numbers = Integer.parseInt(scan.nextLine());
            box.add(numbers);
        }
        System.out.println(box);
        */

        //ЗАДАЧА 3
        /*
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String string = scan.nextLine();
            box.add(string);
        }
        int firstIndex = scan.nextInt();
        int secondIndex = scan.nextInt();
        box.swap(firstIndex, secondIndex);
        System.out.println(box);
         */


        //ЗАДАЧА 4
        /*
        Box<Integer> box = new Box<>();
        for (int i = 0; i < n; i++) {
          int numbers = Integer.parseInt(scan.nextLine());
            box.add(numbers);
        }
        int firstIndex = scan.nextInt();
        int secondIndex = scan.nextInt();
        box.swap(firstIndex, secondIndex);
        System.out.println(box);
         */


        //ЗАДАЧА 5
        /*
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            box.add(text);
        }
        String element = scan.nextLine();
        System.out.println(box.countGreaterThat(element));
         */

        //ЗАДАЧА 6
        Box<Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
           double numbers = Double.parseDouble(scan.nextLine());
            box.add(numbers);
        }
        double element = Double.parseDouble(scan.nextLine());
        System.out.println(box.countGreaterThat(element));

    }
}

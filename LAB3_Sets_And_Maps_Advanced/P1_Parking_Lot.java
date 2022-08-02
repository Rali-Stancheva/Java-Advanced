package ADVANCED.LAB3_Sets_And_Maps_Advanced;

import PIK_3.Exceptions.Upr.Server;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P1_Parking_Lot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();
        String input = scan.nextLine();


        while (!input.equals("END")) {
            String[] data = input.split(", ");
            String command = data[0];
            String car = data[1];

            if (command.equals("IN")) {
                parking.add(car);
            } else {
                parking.remove(car);
            }
                input = scan.nextLine();
        }

        if (parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }

        for (String element : parking) {
            System.out.println(element);
        }
    }
}

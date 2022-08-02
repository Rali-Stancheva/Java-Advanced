package ADVANCED.LAB6_Defining_Classes.P2_Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");
            String brand = info[0];

            Car car;
            if (info.length == 1){
              car = new Car(brand);

            } else {
                car = new Car(info[0],info[1],Integer.parseInt(info[2]));
            }
            carList.add(car);
        }

        carList.forEach(car -> System.out.println(car.toString()));
    }
}

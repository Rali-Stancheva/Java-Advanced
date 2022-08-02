package ADVANCED.LAB6_Defining_Classes.P1_Car_Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Car> carInfoList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");
            String band = info[0];
            String model = info[1];
            int horsePower = Integer.parseInt(info[2]);

           Car car = new Car();
           car.setBand(band);
           car.setModel(model);
           car.setHorsePower(horsePower);
           carInfoList.add(car);
        }

        carInfoList.forEach(car -> System.out.println(car.carInfo()));
    }
}

package ADVANCED.EXERCISE6_Defining_Classes.P3_Speed_Racing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Car> mapCars = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carData = scan.nextLine().split("\\s+");
            String model = carData[0];
            int fuelAmount = Integer.parseInt(carData[1]);
            double fuelCost1km = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, fuelCost1km);
            mapCars.put(model, car);
        }

        String commandInput = scan.nextLine();
        while (!commandInput.equals("End")) {
            String[] info = commandInput.split("\\s+");
            String command = info[0];
            String carModel = info[1];
            int distanceToDrive = Integer.parseInt(info[2]);

            Car carToDrive = mapCars.get(carModel);
            if (!carToDrive.drive(distanceToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }
            commandInput = scan.nextLine();
        }

        for (Car car : mapCars.values()) {
            System.out.println(car.toString());
        }

    }
}

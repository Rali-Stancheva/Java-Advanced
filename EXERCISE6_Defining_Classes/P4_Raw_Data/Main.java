package ADVANCED.EXERCISE6_Defining_Classes.P4_Raw_Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] infoCar = scan.nextLine().split("\\s+");
            String model = infoCar[0];

            int engineSpeed = Integer.parseInt(infoCar[1]);
            int enginePower = Integer.parseInt(infoCar[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(infoCar[3]);
            String cargoType = infoCar[4];   // fragile OR flamable
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            double tire1Pressure = Double.parseDouble(infoCar[5]);
            int tire1Age = Integer.parseInt(infoCar[6]);
            double tire2Pressure = Double.parseDouble(infoCar[7]);
            int tire2Age = Integer.parseInt(infoCar[8]);
            double tire3Pressure = Double.parseDouble(infoCar[9]);
            int tire3Age = Integer.parseInt(infoCar[10]);
            double tire4Pressure = Double.parseDouble(infoCar[11]);
            int tire4Age = Integer.parseInt(infoCar[12]);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            List<Tire> tireList = new ArrayList<>();
            tireList.add(tire);

            Car car = new Car(model, engine, cargo, tireList);
            carList.add(car);
        }

        List<String> fragile = new ArrayList<>();
        List<String> flamable = new ArrayList<>();
        String command = scan.nextLine();
        switch (command) {
            case "fragile":
                for (Car car : carList) {
                    for (Tire tire : car.getTires()) {
                        if (car.getCargo().getCargoType().equals("fragile") && (tire.getTire1Pressure() < 1 || tire.getTire2Pressure() < 1 || tire.getTire3Pressure() < 1 || tire.getTire4Pressure() < 1)) {
                            fragile.add(car.getModel());
                        }
                    }
                }
                break;
            case "flamable":
                for (Car car : carList) {
                    if (car.getEngine().getEnginePower() > 250) {
                        flamable.add(car.getModel());
                    }
                }
                break;
        }

        for (String s : fragile) {
            System.out.println(s);
        }
        for (String s : flamable) {
            System.out.println(s);
        }

    }
}

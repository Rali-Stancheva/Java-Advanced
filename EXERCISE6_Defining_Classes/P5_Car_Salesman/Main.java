package ADVANCED.EXERCISE6_Defining_Classes.P5_Car_Salesman;

import java.awt.image.CropImageFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nEngines = Integer.parseInt(scan.nextLine());
        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < nEngines; i++) {
            Engine engine;

            String[] enginesData = scan.nextLine().split("\\s+");
            String engineModel = enginesData[0];
            int enginePower = Integer.parseInt(enginesData[1]);

            if (enginesData.length == 2) {
                engine = new Engine(engineModel, enginePower);
            } else if (enginesData.length == 4) {
                int displacement = Integer.parseInt(enginesData[2]);
                String efficiency = enginesData[3];
                engine = new Engine(engineModel, enginePower, displacement, efficiency);
            } else {
                String thirdLine = enginesData[2];
                if (Character.isDigit(thirdLine.charAt(0))) {
                    int displacement = Integer.parseInt(enginesData[2]);
                    engine = new Engine(engineModel, enginePower, displacement);
                } else {
                    String efficiency = enginesData[2];
                    engine = new Engine(engineModel, enginePower, efficiency);
                }
            }
            engineList.add(engine);
        }


        int mCar = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < mCar; i++) {
            Car car;
            String[] carData = scan.nextLine().split("\\s+");
            String model = carData[0];
            String engineModel = carData[1];

            if (carData.length == 2) {
                car = new Car(model, engineModel);
            } else if (carData.length == 4) {
                int weight = Integer.parseInt(carData[2]);
                String color = carData[3];
                car = new Car(model, engineModel, weight, color);
            } else {
                String thirdLine = carData[2];
                if (Character.isDigit(thirdLine.charAt(0))) {
                    int weight = Integer.parseInt(thirdLine);
                    car = new Car(model, engineModel, weight);
                } else {
                    String color = thirdLine;
                    car = new Car(model, engineModel, color);
                }
            }
            carList.add(car);

        }
        /*
    FordFocus:
    V4-33:
    Power: 140
    Displacement: 28
    Efficiency: B
    Weight: 1300
    Color: Silver
    */

        for (Car car : carList) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngineModel() + ":");
            engineList.forEach(engine -> {
                if (engine.getModel().equals(car.getEngineModel())){
                    System.out.println(engine.toString());
                }
            });

            if (car.getWeight() == 0){
                System.out.println("Weight: n/a");
            }else{
                System.out.println("Weight: " + car.getWeight());
            }
            System.out.println("Color: " + car.getColor());
        }
    }
}

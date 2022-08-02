package ADVANCED.EXAMS.EXAM_20_February_2021.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getData() {
        return data.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


    public void add(Car car) {
        if (capacity > getData()) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        Car car = null;
        for (Car element : data) {
            if (element.getManufacturer().equals(manufacturer) && element.getModel().equals(model)) {
                car = element;
            }
        }

        if (car == null) {
            return false;
        } else {
            data.remove(car);
            return true;
        }
    }

    public Car getLatestCar() {
        Car car = null;
        int latestYear = Integer.MIN_VALUE;
        for (Car currCar : this.data) {
            if (currCar.getYear() > latestYear) {
                latestYear = currCar.getYear();
                car = currCar;
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are in a car dealership %s:",getName())).append("\n");
        for (Car car : data) {
            builder.append(car.toString()).append("\n");
        }
        return builder.toString();
    }

}

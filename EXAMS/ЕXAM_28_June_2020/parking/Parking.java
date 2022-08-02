package ADVANCED.EXAMS.ЕXAM_28_June_2020.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getData() {
        return data.size();
    }

    public void add(Car car) {
        if (capacity > getData()) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        for (Car e : data) {
            if (e.getManufacturer().equals(manufacturer) && e.getModel().equals(model)){
                data.remove(e);
                return  true;
            }
        }
       return false;
    }


    public Car getLatestCar(){
        Car car = null;
        int latestCar = Integer.MIN_VALUE;
        for (Car element : data) {
            if (element.getYear() > latestCar){
                latestCar = element.getYear();
               car = element;
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model){
        Car car = null;
        for (Car e : data) {
            if (e.getManufacturer().equals(manufacturer) && e.getModel().equals(model)){
                car = e;
            }
        }
        return car;
    }

    public int getCount(){
       return data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
       builder.append("The cars are parked in ").append(this.type).append(":\n");
        for (Car datum : this.data) {
            builder.append(datum.toString()).append(System.lineSeparator());
        }
        return  builder.toString().trim();
    }
}

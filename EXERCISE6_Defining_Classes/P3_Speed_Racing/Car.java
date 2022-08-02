package ADVANCED.EXERCISE6_Defining_Classes.P3_Speed_Racing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTraveled;


    public Car(String model, double fuelAmount, double fuelCostFor1km, int distanceTraveled) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = distanceTraveled;
    }

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }

    public boolean drive(int distanceToDrive) {
        double needFuel = distanceToDrive * this.fuelCostFor1km;
        if (needFuel <= this.fuelAmount) {
            this.distanceTraveled += distanceToDrive;
            this.fuelAmount -= needFuel;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.distanceTraveled);
    }
}

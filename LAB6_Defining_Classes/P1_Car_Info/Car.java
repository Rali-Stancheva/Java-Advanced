package ADVANCED.LAB6_Defining_Classes.P1_Car_Info;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public String getBand() {
        return this.brand;
    }

    public void setBand(String band) {
        this.brand = band;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }


    public String carInfo() {
     return String.format("The car is: %s %s - %d HP.",this.brand,this.model,this.horsePower);
    }
}

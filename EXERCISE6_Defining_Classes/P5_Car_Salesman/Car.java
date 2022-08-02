package ADVANCED.EXERCISE6_Defining_Classes.P5_Car_Salesman;

public class Car {
    private String model;
    private String engineModel;
    //options
    private int weight;
    private String color;


    //при 2 възможни
    public Car(String model, String engineModel) {
        this.model = model;
        this.engineModel = engineModel;
        this.weight = 0;
        this.color = "n/a";
    }

    //при 3 възможни с weight
    public Car(String model, String engineModel, int weight) {
        this.model = model;
        this.engineModel = engineModel;
        this.weight = weight;
        this.color = "n/a";
    }

    //при 3 възможни с color
    public Car(String model, String engineModel, String color) {
        this.model = model;
        this.engineModel = engineModel;
        this.color = color;
        this.weight = 0;
    }

    //при 4 възможни
    public Car(String model, String engineModel, int weight, String color) {
        this.model = model;
        this.engineModel = engineModel;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}

package ADVANCED.EXERCISE6_Defining_Classes.P5_Car_Salesman;

public class Engine {
    private String model;
    private int power;
    //options
    private int displacement;
    private String efficiency;


    //при 2 възможни
    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    //при 3 възможни с displacement
    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    //при 3 възможни с efficiency
    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
        this.displacement = 0;
    }

    //при 4 възможни
    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Power: " + this.power + "\n");

        if (this.displacement == 0) {
            builder.append("Displacement: n/a" + "\n");
        } else{
            builder.append("Displacement: " + this.displacement + "\n");
        }
        builder.append("Efficiency: " + this.efficiency);
        return builder.toString();
    }

}

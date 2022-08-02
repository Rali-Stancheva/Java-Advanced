package ADVANCED.EXERCISE6_Defining_Classes.P4_Raw_Data;

public class Engine {
    private int engineSpeed;
    private int enginePower;


    public Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }

}

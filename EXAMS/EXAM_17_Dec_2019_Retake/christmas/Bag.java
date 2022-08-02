package ADVANCED.EXAMS.EXAM_17_Dec_2019_Retake.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (capacity > data.size()) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        Present presentRemove = null;
        for (Present p : data) {
            if (p.getName().equals(name)) {
                presentRemove = p;
            }
        }
        if (presentRemove == null) {
            return false;
        } else {
            data.remove(presentRemove);
            return true;
        }
    }

    public Present heaviestPresent(){
        Present heaviest = null;
        double max = Double.MIN_VALUE;
        for (Present p : data) {
            if (p.getWeight() > max){
                max = p.getWeight();
                heaviest = p;
            }
        }
        return heaviest;
    }

    public Present getPresent(String name){
        Present present = null;
        for (Present p : data) {
            if (p.getName().equals(name)){
                present = p;
            }
        }
        return present;
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s bag contains:",this.color)).append(System.lineSeparator());
        for (Present p : data) {
            builder.append(p.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}

package ADVANCED.EXAMS.EXAM_26_June_2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getData() {
        return data.size();
    }

    public void add(Pet pet){
       if (capacity > getData()){
           data.add(pet);
       }
    }

    public boolean remove(String name){
        Pet removedPet = null;
        for (Pet p : data) {
            if (p.getName().equals(name)){
               removedPet = p;
            }
        }
        if (removedPet == null){
            return false;
        }else{
            data.remove(removedPet);
            return true;
        }

    }

    public Pet getPet(String name, String owner){
        Pet get = null;
        for (Pet p : data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)){
                get = p;
            }
        }
        return get;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append("The grooming salon has the following clients:").append("\n");
        for (Pet datum : data) {
            builder.append(String.format("%s %s",datum.getName(),datum.getOwner())).append("\n");
        }
        return builder.toString();
    }

}

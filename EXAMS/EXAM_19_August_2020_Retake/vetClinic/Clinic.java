package ADVANCED.EXAMS.EXAM_19_August_2020_Retake.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet removedPet = null;

        for (Pet p : data) {
            if (p.getName().equals(name)) {
                removedPet = p;
            }
        }

        if (removedPet == null) {
            return false;
        } else {
            data.remove(removedPet);
            return true;
        }
    }

    public Pet getPet(String name, String owner) {
        Pet getPet = null;

        for (Pet p : data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                getPet = p;
            }
        }

        return getPet;
    }

    public Pet getOldestPet() {
        Pet oldest = null;

        int max = Integer.MIN_VALUE;
        for (Pet p : data) {
            if (p.getAge() > max) {
                max = p.getAge();
                oldest = p;
            }
        }
        return oldest;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The clinic has the following patients:\n");
        for (Pet p : data) {
            builder.append(String.format("%s %s\n", p.getName(), p.getOwner()));
        }
        return builder.toString();
    }
}
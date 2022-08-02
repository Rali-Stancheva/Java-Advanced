package ADVANCED.EXAMS.EXAM_23_October_2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster; //list with persons

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public int getPersonList() {
        return roster.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Person person) {
        if (capacity > getPersonList()) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        Person removedPerson = null;
        for (Person person : roster) {
            if (person.getName().equals(name)) {
                removedPerson = person;
            }
        }
        if (removedPerson == null) {
            return false;
        } else {
            roster.remove(removedPerson);
            return true;
        }
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The people in the hotel %s are:",getName())).append("\n");
        for (Person person : roster) {
            builder.append(person.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}

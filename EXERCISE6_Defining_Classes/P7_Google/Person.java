package ADVANCED.EXERCISE6_Defining_Classes.P7_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Car car;
    private Company company;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person() {
        car = null;
        company = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public Person(Car car, Company company, List<Parents> parents, List<Children> children, List<Pokemon> pokemons) {
        this.car = car;
        this.company = company;
        this.parents = parents;
        this.children = children;
        this.pokemons = pokemons;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        //Company:
        //Car:
        //Trabant 30
        //Pokemon:
        //Electrode Electricity
        //Parents:
        //Children:

        StringBuilder builder = new StringBuilder();

        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company).append("\n");
        }

        builder.append("Car:").append("\n");
        if (car != null){
            builder.append(car).append("\n");
        }

        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemons) {
            builder.append(pokemon).append("\n");
        }

        builder.append("Parents:").append("\n");
        for (Parents parent : parents) {
            builder.append(parent).append("\n");
        }

        builder.append("Children:").append("\n");
        for (Children child : children) {
            builder.append(child).append("\n");
        }

        return builder.toString();
    }
}

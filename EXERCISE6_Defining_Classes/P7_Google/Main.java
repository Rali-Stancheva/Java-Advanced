package ADVANCED.EXERCISE6_Defining_Classes.P7_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> peopleDataMap = new HashMap<>();

        String information = scan.nextLine();
        while (!information.equals("End")){
            String[] parameters = information.split("\\s+");
            String personName = parameters[0];
            String typeCommand = parameters[1];

            if (!peopleDataMap.containsKey(personName)){
                peopleDataMap.put(personName,new Person());
            }

            switch (typeCommand){
                case "company":
                    String companyName = parameters[2];
                    String department = parameters[3];
                    double salary = Double.parseDouble(parameters[4]);
                    Company company = new Company(companyName,department,salary);
                    peopleDataMap.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = parameters[2];
                    String pokemonType = parameters[3];
                    Pokemon pokemon = new Pokemon(pokemonName,pokemonType);
                    peopleDataMap.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = parameters[2];
                    String parentBirthday = parameters[3];
                    Parents parents = new Parents(parentName,parentBirthday);
                    peopleDataMap.get(personName).getParents().add(parents);
                    break;
                case "children":
                    String childName = parameters[2];
                    String childBirthday = parameters[3];
                    Children children = new Children(childName,childBirthday);
                    peopleDataMap.get(personName).getChildren().add(children);
                    break;
                case "car":
                    String carModel = parameters[2];
                    int carSpeed = Integer.parseInt(parameters[3]);
                    Car car = new Car(carModel,carSpeed);
                    peopleDataMap.get(personName).setCar(car);
                    break;
            }

            information = scan.nextLine();
        }

        String wantedPerson = scan.nextLine();
        System.out.println(wantedPerson);

        //данните на човек
        Person personalData = peopleDataMap.get(wantedPerson);
        System.out.println(personalData);
    }
}

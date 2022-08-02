package ADVANCED.EXERCISE6_Defining_Classes.P6_Pokemon_Trainer;

public class Pokemon {
    private String pokemonName;
    private String element;
    private int health;

    public Pokemon(String pokemonName, String element, int health) {
        this.pokemonName = pokemonName;
        this.element = element;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public String getElement() {
        return element;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void lowerHealth(){
        this.health -= 10;
    }
}

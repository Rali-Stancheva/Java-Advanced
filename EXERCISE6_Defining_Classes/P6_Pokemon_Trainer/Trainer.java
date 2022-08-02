package ADVANCED.EXERCISE6_Defining_Classes.P6_Pokemon_Trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Trainer {
    private List<Pokemon> pokemons;
    private int badges;

    public Trainer() {
        this.pokemons = new ArrayList<>();
        this.badges = 0;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void setBadges() {
        this.badges++;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public int pokemonSize() {
        return this.pokemons.size();
    }

    private Function<Pokemon,Pokemon> damagePokemon = pokemon ->
            new Pokemon(pokemon.getPokemonName(),pokemon.getElement(),pokemon.getHealth() - 10);

    public void missingPokemon() {
        this.pokemons = this.pokemons
                .stream()
                .map(damagePokemon)
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }

    public int getBadges() {
        return badges;
    }
}

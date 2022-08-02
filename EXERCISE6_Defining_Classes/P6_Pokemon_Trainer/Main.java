package ADVANCED.EXERCISE6_Defining_Classes.P6_Pokemon_Trainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Trainer> trainerPokemonMap = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!input.equals("Tournament")) {
            String[] infoData = input.split("\\s+");

            String trainerName = infoData[0];
            String pokemonName = infoData[1];
            String pokemonElement = infoData[2];
            int pokemonHealth = Integer.parseInt(infoData[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainerPokemonMap.putIfAbsent(trainerName, new Trainer());
            trainerPokemonMap.get(trainerName).addPokemon(pokemon);
            input = scan.nextLine();
        }

        input = scan.nextLine();
        while (!input.equals("End")) {
            for (Map.Entry<String, Trainer> trainer : trainerPokemonMap.entrySet()) {
                if (trainer.getValue().pokemonSize() > 0) {
                    boolean havePokemon = false;
                    for (Pokemon pokemon : trainer.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(input)) {
                            havePokemon = true;
                            trainer.getValue().setBadges();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        trainer.getValue().missingPokemon();
                    }
                }
            }

            input = scan.nextLine();
        }
        trainerPokemonMap.entrySet().stream()
                .sorted((left, right) -> Integer.compare(right.getValue().getBadges(), left.getValue().getBadges()))
                .forEach(t -> {
                    System.out.printf("%s %s %s\n", t.getKey(), t.getValue().getBadges(), t.getValue().pokemonSize());
                });
    }
}

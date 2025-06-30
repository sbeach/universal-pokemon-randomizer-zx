package mock;

import com.dabomstew.pkrandom.pokemon.Evolution;
import com.dabomstew.pkrandom.pokemon.EvolutionType;
import com.dabomstew.pkrandom.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonHelper {

    public static Pokemon create(int number, String name) {
        Pokemon poke = new Pokemon();
        poke.number = number;
        poke.name = name;
        return poke;
    }

    public static List<Pokemon> startersDefault() {
        List<Pokemon> result = new ArrayList<>();
        // The starter logic is based on a dropdown list that includes "Random" in index 0.
        // Therefore, we have to include "Random" in our mock list for the logic to do what it needs.
        Pokemon random = create(0, "Random");
        result.add(random);

        Pokemon bulbasaur = create(1, "Bulbasaur");
        Pokemon ivysaur = create(2, "Ivysaur");
        Pokemon venasaur = create(3, "Venasaur");
        link(bulbasaur, ivysaur);
        link(ivysaur, venasaur);

        Pokemon charmander = create(4, "Charmander");
        Pokemon charmeleon = create(5, "Charmeleon");
        Pokemon charizard = create(6, "Charizard");
        link(charmander, charmeleon);
        link(charmeleon, charizard);

        Pokemon squirtle = create(7, "Squirtle");
        Pokemon wartortle = create(8, "Wartortle");
        Pokemon blastoise = create(9, "Blastoise");
        link(squirtle, wartortle);
        link(wartortle, blastoise);

        result.add(bulbasaur);
        result.add(ivysaur);
        result.add(venasaur);
        result.add(charmander);
        result.add(charmeleon);
        result.add(charizard);
        result.add(squirtle);
        result.add(wartortle);
        result.add(blastoise);

        return result;
    }

    /**
     * A helper to cleanly link two Pokémon in an evolution chain.
     * This abstracts away the need to manually create and add Evolution objects.
     */
    public static void link(Pokemon from, Pokemon to) {
        Evolution evolution = new Evolution(from, to, true, EvolutionType.LEVEL, 0);
        from.evolutionsFrom.add(evolution);
    }
}

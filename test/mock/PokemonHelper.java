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

    /**
     * A helper to cleanly link two Pokémon in an evolution chain.
     * This abstracts away the need to manually create and add Evolution objects.
     */
    public static void link(Pokemon from, Pokemon to) {
        Evolution evolution = new Evolution(from, to, true, EvolutionType.LEVEL, 0);
        from.evolutionsFrom.add(evolution);
    }
}

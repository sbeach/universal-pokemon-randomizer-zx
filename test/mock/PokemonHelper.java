package mock;

import com.dabomstew.pkrandom.pokemon.Pokemon;

public class PokemonHelper {

    public static Pokemon create(int number, String name) {
        Pokemon poke = new Pokemon();
        poke.number = number;
        poke.name = name;
        return poke;
    }
}

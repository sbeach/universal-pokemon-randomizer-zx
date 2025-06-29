package com.dabomstew.pkrandom.romhandlers;

import com.dabomstew.pkrandom.Settings;
import com.dabomstew.pkrandom.pokemon.Pokemon;
import mock.AbstractRomHandlerMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the customStarters method in AbstractRomHandler using a mock implementation.
 * This avoids the need for a real ROM file.
 */
class CustomStartersTest {

    private AbstractRomHandlerMock romHandlerMock;

    @BeforeEach
    void setUp() {
        // --- Arrange: Create and configure a mock RomHandler ---
        // We use a mock to avoid needing a real ROM file.
        // The mock is pre-loaded with predictable data for our tests.
        // A fixed seed (0) is used for the Random object to make "random" choices predictable.
        romHandlerMock = new AbstractRomHandlerMock(new Random(0L));

        // Create a dummy list of Pokémon to simulate the data read from a ROM.
        List<Pokemon> pokemonList = new ArrayList<>();
        Pokemon poke = new Pokemon();
        // The starter logic is based on a dropdown list that includes "Random" in index 0.
        // When the custom starters are parsed, the logic checks the number minus 1, since Random is the first option.
        // Therefore, we have to include "Random" in our mock list for the logic to do what it needs.
        poke.number = 1;
        poke.name = "Random";
        pokemonList.add(poke);
        poke = new Pokemon();
        poke.number = 2;
        poke.name = "Bulbasaur";
        pokemonList.add(poke);
        poke = new Pokemon();
        poke.number = 3;
        poke.name = "Ivysaur";
        pokemonList.add(poke);
        poke = new Pokemon();
        poke.number = 4;
        poke.name = "Venusaur";
        pokemonList.add(poke);
        poke = new Pokemon();
        poke.number = 5;
        poke.name = "Charmander";
        pokemonList.add(poke);
        poke = new Pokemon();
        poke.number = 6;
        poke.name = "Charmeleon";
        pokemonList.add(poke);
        poke = new Pokemon();
        poke.number = 7;
        poke.name = "Charizard";
        pokemonList.add(poke);
        poke = new Pokemon();
        poke.number = 8;
        poke.name = "Squirtle";
        pokemonList.add(poke);
        poke = new Pokemon();
        poke.number = 9;
        poke.name = "Wartortle";
        pokemonList.add(poke);
        poke = new Pokemon();
        poke.number = 10;
        poke.name = "Blastoise";
        pokemonList.add(poke);

        // Configure the mock with our dummy data.
        // This assumes the mock has methods to set its internal state.
        romHandlerMock.pokemonList = pokemonList;
        romHandlerMock.mainPokemonList = pokemonList;
        romHandlerMock.mainPokemonListInclFormes = pokemonList;
    }
}

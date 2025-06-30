package com.dabomstew.pkrandom.romhandlers;

import com.dabomstew.pkrandom.Settings;
import com.dabomstew.pkrandom.pokemon.Pokemon;
import mock.MockRomHandler;
import mock.PokemonHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the customStarters method in AbstractRomHandler using a mock implementation.
 * This avoids the need for a real ROM file.
 */
class CustomStartersTest {

    private MockRomHandler romHandlerMock;

    @BeforeEach
    void setUp() {
        // --- Arrange: Create and configure a mock RomHandler ---
        // We use a mock to avoid needing a real ROM file.
        // The mock is pre-loaded with predictable data for our tests.
        // A fixed seed (0) is used for the Random object to make "random" choices predictable.
        romHandlerMock = new MockRomHandler(new Random(0L));

        // Create a dummy list of Pokémon to simulate the data read from a ROM.
        List<Pokemon> pokemonList = PokemonHelper.startersDefault();

        // Configure the mock with our dummy data.
        // This assumes the mock has methods to set its internal state.
        romHandlerMock.pokemonList = pokemonList;
        romHandlerMock.mainPokemonListInclFormes = pokemonList;
    }

    @Test
    void customStarters_setsSpecificPokemon() {
        // --- Arrange ---
        // Create a settings object configured for custom starters.
        // The numbers correspond to the Pokedex ID + 1, as used in the UI.
        Settings settings = new Settings();
        settings.setStartersMod(Settings.StartersMod.CUSTOM);
        // Pokedex IDs: 4=Charmander, 7=Squirtle, 1=Bulbasaur
        settings.setCustomStarters(new int[]{4, 7, 1});

        // --- Act ---
        // Call the method we want to test.
        romHandlerMock.customStarters(settings);

        // --- Assert ---
        // The mock's `setStarters` method will have been called. We can
        // verify the result using the mock's `getStarters` method.
        List<Pokemon> newStarters = romHandlerMock.getStarters();
        assertEquals(3, newStarters.size(), "There should be 3 starters.");
        assertEquals("Charmander", newStarters.get(0).name, "First starter should be Charmander.");
        assertEquals("Squirtle", newStarters.get(1).name, "Second starter should be Squirtle.");
        assertEquals("Bulbasaur", newStarters.get(2).name, "Third starter should be Bulbasaur.");
    }

    @Test
    void customStarters_withRandomOption() {
        // --- Arrange ---
        // The "Random" option is represented by index 0 in the customStarters array.
        Settings settings = new Settings();
        settings.setStartersMod(Settings.StartersMod.CUSTOM);
        // Pokedex IDs: 4=Charmander, 0=Random, 1=Bulbasaur
        settings.setCustomStarters(new int[]{4, 0, 1});

        // --- Act ---
        romHandlerMock.customStarters(settings);

        // --- Assert ---
        List<Pokemon> newStarters = romHandlerMock.getStarters();
        assertEquals(3, newStarters.size(), "There should be 3 starters.");
        assertEquals("Charmander", newStarters.get(0).name, "First starter should be Charmander.");

        // The second starter should be a "random" one. Because we used a fixed seed (0)
        // for our Random object, the "random" choice will always be the same.
        // The first call to random.nextInt(9) with seed 0 returns 6. The pokemon at index 6 is Squirtle.
        assertEquals("Squirtle", newStarters.get(1).name, "Second starter should be a predictable random choice (Squirtle).");

        assertEquals("Bulbasaur", newStarters.get(2).name, "Third starter should be Bulbasaur.");
    }

    @Test
    void customStarters_withMultipleRandomOptions() {
        // --- Arrange ---
        Settings settings = new Settings();
        settings.setStartersMod(Settings.StartersMod.CUSTOM);
        // Pokedex IDs: 4=Charmander, 0=Random, 0=Random
        settings.setCustomStarters(new int[]{4, 0, 0});

        // --- Act ---
        romHandlerMock.customStarters(settings);

        // --- Assert ---
        List<Pokemon> newStarters = romHandlerMock.getStarters();
        assertEquals(3, newStarters.size(), "There should be 3 starters.");
        assertEquals("Charmander", newStarters.get(0).name, "First starter should be Charmander.");

        // With a seed of 0, the random sequence is predictable:
        // 1. random.nextInt(9) -> 6 (Squirtle). Not banned, not picked. Use it.
        // 2. random.nextInt(9) -> 6 (Squirtle). Already picked. Reroll.
        // 3. random.nextInt(9) -> 7 (Wartortle). Not banned, not picked. Use it.
        assertEquals("Squirtle", newStarters.get(1).name, "Second starter should be Squirtle.");
        assertEquals("Wartortle", newStarters.get(2).name, "Third starter should be Wartortle.");
    }

    @Test
    void customStarters_withExtraStarters() {
        // --- Arrange ---
        Settings settings = new Settings();
        settings.setStartersMod(Settings.StartersMod.CUSTOM);
        // Pokedex IDs: 5=Charmeleon, 2=Ivysaur, 8=Wartortle
        settings.setCustomStarters(new int[]{5, 2, 8});
        // XY is considered to have 6 starters
        romHandlerMock.starterCount = 6;

        // --- Act ---
        romHandlerMock.customStarters(settings);

        // --- Assert ---
        List<Pokemon> newStarters = romHandlerMock.getStarters();
        assertEquals(6, newStarters.size(), "There should be 6 starters.");
        assertEquals("Charmeleon", newStarters.get(0).name, "First starter should be Charmeleon.");
        assertEquals("Ivysaur", newStarters.get(1).name, "Second starter should be Ivysaur.");
        assertEquals("Wartortle", newStarters.get(2).name, "Second starter should be Wartortle.");

        // from here, remaining starters are random among those that have two evolutions
        // given that we only have three qualifying Pokemon in the list,
        // we merely need to show that they are all present
        List<String> remaining = new ArrayList<>();
        remaining.add("Bulbasaur");
        remaining.add("Charmander");
        remaining.add("Squirtle");
        assertTrue(remaining.contains(newStarters.get(3).name), "Fourth starter should be one of Bulbasaur, Charmander, or Squirtle");
        assertTrue(remaining.contains(newStarters.get(4).name), "Fifth starter should be one of Bulbasaur, Charmander, or Squirtle");
        assertTrue(remaining.contains(newStarters.get(5).name), "Sixth starter should be one of Bulbasaur, Charmander, or Squirtle");
    }
}

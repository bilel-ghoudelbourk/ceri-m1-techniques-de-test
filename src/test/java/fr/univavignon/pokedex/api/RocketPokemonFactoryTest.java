package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RocketPokemonFactoryTest {

    private RocketPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void createPokemonKnownIndexTest() {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 500, 60, 3000, 3);
        assertNotNull(pokemon);
        assertEquals("Bulbasaur", pokemon.getName());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        assertEquals(1, pokemon.getIv(), 0.0);
    }

    @Test
    public void createPokemonUnknownIndexTest() {
        Pokemon pokemon = pokemonFactory.createPokemon(999, 500, 60, 3000, 3);
        assertNotNull(pokemon);
        assertEquals("MISSINGNO", pokemon.getName());
    }

    @Test
    public void createPokemonNegativeIndexTest() {
        Pokemon pokemon = pokemonFactory.createPokemon(-1, 500, 60, 3000, 3);
        assertNotNull(pokemon);
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0, pokemon.getIv(), 0.0);
    }

    @Test
    public void randomStatsTest() {
        int attackTotal = 0;
        int defenseTotal = 0;
        int staminaTotal = 0;
        int iterations = 10;
        for (int i = 0; i < iterations; i++) {
            Pokemon pokemon = pokemonFactory.createPokemon(1, 500, 60, 3000, 3);
            attackTotal += pokemon.getAttack();
            defenseTotal += pokemon.getDefense();
            staminaTotal += pokemon.getStamina();
        }
        double avgAttack = attackTotal / (double) iterations;
        double avgDefense = defenseTotal / (double) iterations;
        double avgStamina = staminaTotal / (double) iterations;

        assertTrue(avgAttack >= 45 && avgAttack <= 55);
        assertTrue(avgDefense >= 45 && avgDefense <= 55);
        assertTrue(avgStamina >= 45 && avgStamina <= 55);
    }
}

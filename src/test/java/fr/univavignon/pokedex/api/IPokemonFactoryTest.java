package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void createPokemonTest() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "Bulbizarre", 130, 130, 100, 613, 64, 4000, 4, 0.91));

        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull(pokemon);
        assertTrue(pokemon.getAttack() >= 126 && pokemon.getAttack() <= 141);
        assertTrue(pokemon.getDefense() >= 126 && pokemon.getDefense() <= 141);
        assertTrue(pokemon.getStamina() >= 90 && pokemon.getStamina() <= 105);

    }

    @Test
    public void createPokemonWithSpecificIndexTest() {
        int pokemonIndex = 133;
        Pokemon aquali = new Pokemon(pokemonIndex, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0);
        when(pokemonFactory.createPokemon(pokemonIndex, 2729, 202, 5000, 4)).thenReturn(aquali);

        Pokemon createdPokemon = pokemonFactory.createPokemon(pokemonIndex, 2729, 202, 5000, 4);

        assertEquals(aquali, createdPokemon);
    }

}

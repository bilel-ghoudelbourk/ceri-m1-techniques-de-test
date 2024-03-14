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
    public void createPokemonWithSpecificIndexTest() {
        int pokemonIndex = 133;
        Pokemon aquali = new Pokemon(pokemonIndex, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0);
        when(pokemonFactory.createPokemon(pokemonIndex, 2729, 202, 5000, 4)).thenReturn(aquali);

        Pokemon createdPokemon = pokemonFactory.createPokemon(pokemonIndex, 2729, 202, 5000, 4);

        assertEquals(aquali, createdPokemon);
    }

    @Test
    public void createPokemonTest() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4))
                .thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.91));

        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull(pokemon);
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(90, pokemon.getStamina());
    }


}

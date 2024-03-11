package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokedexTest {

    private IPokedex pokedex;

    @Before
    public void setUp() {
        pokedex = mock(IPokedex.class);
    }


    @Test
    public void addAndGetPokemonTest() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 130, 130, 100, 613, 64, 4000, 4, 0.91);
        when(pokedex.addPokemon(pokemon)).thenReturn(0);
        when(pokedex.getPokemon(0)).thenReturn(pokemon);

        int index = pokedex.addPokemon(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(index);

        assertNotNull(retrievedPokemon);
        assertEquals(pokemon.getName(), retrievedPokemon.getName());
    }
}

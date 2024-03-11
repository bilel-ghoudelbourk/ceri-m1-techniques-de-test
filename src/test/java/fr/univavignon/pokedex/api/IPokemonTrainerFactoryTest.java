package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;

    @Before
    public void setUp() {
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
    }


    @Test
    public void createTrainerTest() {
        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.VALOR, mock(IPokedex.class));
        when(pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, null)).thenReturn(trainer);

        PokemonTrainer createdTrainer = pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, null);

        assertEquals("Ash", createdTrainer.getName());
        assertEquals(Team.VALOR, createdTrainer.getTeam());
    }

}

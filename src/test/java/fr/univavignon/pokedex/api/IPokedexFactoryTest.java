package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void createPokedexTest() {
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(null, null)).thenReturn(pokedex);

        IPokedex createdPokedex = pokedexFactory.createPokedex(null, null);

        assertNotNull(createdPokedex);
    }
    @Test
    public void createMultiplePokedexesReturnDifferentInstancesTest() {
        IPokedex pokedex1 = mock(IPokedex.class);
        IPokedex pokedex2 = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(null, null)).thenReturn(pokedex1, pokedex2);

        IPokedex createdPokedex1 = pokedexFactory.createPokedex(null, null);
        IPokedex createdPokedex2 = pokedexFactory.createPokedex(null, null);

        assertNotNull(createdPokedex1);
        assertNotNull(createdPokedex2);
        assertNotSame(createdPokedex1, createdPokedex2);
    }


}

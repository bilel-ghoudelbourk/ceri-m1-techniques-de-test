package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        metadataProvider=new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
        pokedexFactory = new PokedexFactory(metadataProvider, pokemonFactory);
    }

    @Test
    public void createPokedexTest() {
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(createdPokedex);
    }

}

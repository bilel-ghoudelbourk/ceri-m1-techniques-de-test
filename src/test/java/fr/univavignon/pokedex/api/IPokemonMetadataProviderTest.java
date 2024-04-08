package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
            metadataProvider=new PokemonMetadataProvider();
    }


    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        PokemonMetadata bulbizarre=metadataProvider.getPokemonMetadata(0);

        assertNotNull(bulbizarre);
        assertEquals("Bulbizarre", bulbizarre.getName());
        assertEquals(126, bulbizarre.getAttack());
        assertEquals(126, bulbizarre.getDefense());
        assertEquals(90, bulbizarre.getStamina());

        PokemonMetadata aquali = metadataProvider.getPokemonMetadata(133);
        assertNotNull(aquali);
        assertEquals("Aquali", aquali.getName());
        assertEquals(186, aquali.getAttack());
        assertEquals(168, aquali.getDefense());
        assertEquals(260, aquali.getStamina());

    }

    @Test(expected = PokedexException.class)
    public void getPokemonMetadataInvalidIdTest() throws PokedexException {
        metadataProvider.getPokemonMetadata(-1);
    }

}

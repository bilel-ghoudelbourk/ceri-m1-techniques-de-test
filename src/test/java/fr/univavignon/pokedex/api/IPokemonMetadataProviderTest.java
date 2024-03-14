package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);

        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());

    }




}

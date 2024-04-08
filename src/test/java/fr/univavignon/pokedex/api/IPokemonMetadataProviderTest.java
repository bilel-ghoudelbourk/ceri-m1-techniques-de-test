package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        try {
            // Initialisation du mock
            metadataProvider = mock(IPokemonMetadataProvider.class);

            // Configuration des réponses simulées pour des IDs spécifiques
            when(metadataProvider.getPokemonMetadata(0))
                    .thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
            when(metadataProvider.getPokemonMetadata(133))
                    .thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));

            // Simulation d'une exception pour un ID invalide
            when(metadataProvider.getPokemonMetadata(-1))
                    .thenThrow(new PokedexException("Invalid Pokémon ID"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        // Test pour Bulbizarre
        PokemonMetadata bulbizarre = metadataProvider.getPokemonMetadata(0);
        assertNotNull(bulbizarre);
        assertEquals("Bulbizarre", bulbizarre.getName());
        assertEquals(126, bulbizarre.getAttack());
        assertEquals(126, bulbizarre.getDefense());
        assertEquals(90, bulbizarre.getStamina());

        // Test pour Aquali
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

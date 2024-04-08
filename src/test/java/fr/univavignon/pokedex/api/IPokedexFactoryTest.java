package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokedexFactoryTest {

    private PokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
        pokedexFactory = new PokedexFactory(metadataProvider, pokemonFactory);
    }

    @Test
    public void createPokedexWithNonNullParametersTest() {
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull( createdPokedex);
    }

    @Test
    public void createPokedexWithNullParametersTest() {
        IPokedex createdPokedex = pokedexFactory.createPokedex(null, null);
        assertNotNull(createdPokedex);
        // Further tests can be done to check if it's using the factory's default providers
    }

    @Test
    public void testPokedexFunctionalities() throws PokedexException {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull("Pokedex doit être creer", pokedex);

        // Test adding a Pokemon and retrieving it to ensure Pokedex is functional
        Pokemon testPokemon = pokemonFactory.createPokemon(0, 100, 100, 1000, 10);
        int pokemonIndex = pokedex.addPokemon(testPokemon);
        assertEquals("L'index du pokemon ajouté doit être 0", 0, pokemonIndex);

        Pokemon pokemon = pokedex.getPokemon(pokemonIndex);
        assertNotNull(pokemon);
        assertEquals("pokemon il faut égale le pokemon ajouté", testPokemon, pokemon);
    }
}

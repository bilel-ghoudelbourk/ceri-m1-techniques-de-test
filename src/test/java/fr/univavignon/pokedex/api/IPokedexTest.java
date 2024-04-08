package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Comparator;

public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider=new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void addPokemonTest() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 130, 130, 100, 613, 64, 4000, 4, 0.91);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
    }

    @Test
    public void getPokemonTest() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 130, 130, 100, 613, 64, 4000, 4, 0.91);
        pokedex.addPokemon(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertNotNull(retrievedPokemon);
        assertEquals("Bulbizarre", retrievedPokemon.getName());
    }

    @Test
    public void validatePokemonPropertiesTest() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 130, 130, 100, 613, 64, 4000, 4, 0.91);
        pokedex.addPokemon(pokemon);

        Pokemon retrievedPokemon = pokedex.getPokemon(0);

        assertNotNull(retrievedPokemon);
        assertEquals(0, retrievedPokemon.getIndex());
        assertEquals("Bulbizarre", retrievedPokemon.getName());
        assertEquals(130, retrievedPokemon.getAttack());
    }

    @Test
    public void pokedexSizeTest() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        pokedex.addPokemon(pokemon);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void getPokemonsTest() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        pokedex.addPokemon(pokemon);

        List<Pokemon> retrievedPokemons = pokedex.getPokemons();
        assertNotNull(retrievedPokemons);
        assertEquals(1, retrievedPokemons.size());
        assertEquals(pokemon, retrievedPokemons.get(0));
    }

    @Test
    public void getPokemonsWithOrderTest() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        pokedex.addPokemon(pokemon);
        Comparator<Pokemon> comparator = Comparator.comparingInt(Pokemon::getCp);

        List<Pokemon> sortedPokemons = pokedex.getPokemons(comparator);
        assertNotNull(sortedPokemons);
        assertEquals(1, sortedPokemons.size());
        assertEquals(pokemon, sortedPokemons.get(0));
    }

    @Test(expected = PokedexException.class)
    public void getPokemonInvalidIndexTest() throws PokedexException {
        pokedex.getPokemon(-1);
    }

    @Test
    public void getPokemonMetadataValidIndexTest() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals("Bulbizarre", metadata.getName());
    }

    @Test(expected = PokedexException.class)
    public void getPokemonMetadataInvalidIndexTest() throws PokedexException {
        pokedex.getPokemonMetadata(1000);
    }

    @Test
    public void createPokemonTest() {
        Pokemon pokemon = pokedex.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(pokemon);
        assertEquals("Bulbizarre", pokemon.getName());
    }

    @Test
    public void getPokemonsSortedByNameTest() {
        pokedex.addPokemon(new Pokemon(1, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1));
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56));

        List<Pokemon> sortedByName = pokedex.getPokemons(PokemonComparators.NAME);
        assertNotNull(sortedByName);
        assertFalse(sortedByName.isEmpty());
        assertEquals("Aquali", sortedByName.get(0).getName());
    }

    @Test
    public void getPokemonsSortedByIndexTest() {
        pokedex.addPokemon(new Pokemon(1, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1));
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56));

        List<Pokemon> sortedByIndex = pokedex.getPokemons(PokemonComparators.INDEX);
        assertNotNull(sortedByIndex);
        assertFalse(sortedByIndex.isEmpty());
        assertEquals(0, sortedByIndex.get(0).getIndex());
    }


}

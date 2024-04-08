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

}

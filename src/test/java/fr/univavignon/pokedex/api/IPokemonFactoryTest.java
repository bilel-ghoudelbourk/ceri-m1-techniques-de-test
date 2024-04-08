package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider=new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
    }

    @Test
    public void createPokemonTest() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull("Le Pokémon créé ne devrait pas être null", pokemon);
        assertEquals("Le nom du Pokémon ne correspond pas", "Bulbizarre", pokemon.getName());
        assertEquals("L'attaque du Pokémon ne correspond pas", 126, pokemon.getAttack());
        assertEquals("La défense du Pokémon ne correspond pas", 126, pokemon.getDefense());
        assertEquals("L'endurance (stamina) du Pokémon ne correspond pas", 90, pokemon.getStamina());
        assertEquals("Les CP du Pokémon ne correspondent pas", 613, pokemon.getCp());
    }
}

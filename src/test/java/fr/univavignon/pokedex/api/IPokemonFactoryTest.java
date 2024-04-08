package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    private PokemonFactory pokemonFactory;
    private PokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
    }

    @Test
    public void createPokemonTest() {
        int index = 0;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;
        double iv = 0;

        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull("Le Pokémon créé ne devrait pas être null", pokemon);
        assertEquals("Le nom du Pokémon ne correspond pas", "Bulbizarre", pokemon.getName());
        assertEquals("L'attaque du Pokémon ne correspond pas", 126, pokemon.getAttack());
        assertEquals("La défense du Pokémon ne correspond pas", 126, pokemon.getDefense());
        assertEquals("L'endurance (stamina) du Pokémon ne correspond pas", 90, pokemon.getStamina());
        assertEquals("Les CP du Pokémon ne correspondent pas", cp, pokemon.getCp());
        assertEquals("L'HP du Pokémon ne correspond pas", hp, pokemon.getHp());
        assertEquals("La dust du Pokémon ne correspond pas", dust, pokemon.getDust());
        assertEquals("La candy du Pokémon ne correspond pas", candy, pokemon.getCandy());
        assertEquals("L'IV du Pokémon ne correspond pas", iv, pokemon.getIv(), 0.001);
    }

    @Test(expected = RuntimeException.class)
    public void createPokemonWithInvalidIndexTest() {
        pokemonFactory.createPokemon(1000, 500, 50, 3000, 2);
    }

    @Test
    public void createPokemonWithExtremeValuesTest() {
        int index = 0;
        int cp = Integer.MAX_VALUE;
        int hp = Integer.MAX_VALUE;
        int dust = Integer.MAX_VALUE;
        int candy = Integer.MAX_VALUE;
        double iv = 0;

        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull("Le Pokémon créé ne devrait pas être null", pokemon);
        assertEquals("Les CP du Pokémon ne correspondent pas", cp, pokemon.getCp());
        assertEquals("L'HP du Pokémon ne correspond pas", hp, pokemon.getHp());
        assertEquals("La dust du Pokémon ne correspond pas", dust, pokemon.getDust());
        assertEquals("La candy du Pokémon ne correspond pas", candy, pokemon.getCandy());
        assertEquals("L'IV du Pokémon ne correspond pas", iv, pokemon.getIv(), 0.001);
    }
}

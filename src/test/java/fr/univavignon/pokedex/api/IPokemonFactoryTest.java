package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }


    private void verifyPokemon(Pokemon expected, Pokemon actual) {
        assertNotNull(actual);
        assertEquals("L'index du Pokémon ne correspond pas", expected.getIndex(), actual.getIndex());
        assertEquals("Le nom du Pokémon ne correspond pas", expected.getName(), actual.getName());
        assertEquals("L'attaque du Pokémon ne correspond pas", expected.getAttack(), actual.getAttack());
        assertEquals("La défense du Pokémon ne correspond pas", expected.getDefense(), actual.getDefense());
        assertEquals("L'endurance du Pokémon ne correspond pas", expected.getStamina(), actual.getStamina());
        assertEquals("Les CP du Pokémon ne correspondent pas", expected.getCp(), actual.getCp());
        assertEquals("Les HP du Pokémon ne correspondent pas", expected.getHp(), actual.getHp());
        assertEquals("La poussière d'étoile du Pokémon ne correspond pas", expected.getDust(), actual.getDust());
        assertEquals("Les bonbons du Pokémon ne correspondent pas", expected.getCandy(), actual.getCandy());
        assertEquals("L'IV du Pokémon ne correspond pas", expected.getIv(), actual.getIv(), 0.001);
    }

    @Test
    public void createBulbizarreTest() {
        int index = 0;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;
        double iv = 0.56;

        Pokemon expectedBulbizarre = new Pokemon(index, "Bulbizarre", 126, 126, 90, cp, hp, dust, candy, iv);
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedBulbizarre);

        Pokemon createdBulbizarre = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        verifyPokemon(expectedBulbizarre, createdBulbizarre);
    }

    @Test
    public void createAqualiTest() {
        int index = 133;
        int cp = 2729;
        int hp = 202;
        int dust = 5000;
        int candy = 4;
        double iv = 1.00;

        Pokemon expectedAquali = new Pokemon(index, "Aquali", 186, 168, 260, cp, hp, dust, candy, iv);
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedAquali);

        Pokemon createdAquali = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        verifyPokemon(expectedAquali, createdAquali);
    }

    @Test
    public void createPokemonTest() {
        int indexBulbizarre = 0;
        int indexAquali = 133;
        Pokemon bulbizarre = new Pokemon(indexBulbizarre, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon aquali = new Pokemon(indexAquali, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0);

        when(pokemonFactory.createPokemon(indexBulbizarre, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        when(pokemonFactory.createPokemon(indexAquali, 2729, 202, 5000, 4)).thenReturn(aquali);

        Pokemon createdBulbizarre = pokemonFactory.createPokemon(indexBulbizarre, 613, 64, 4000, 4);
        assertNotNull(createdBulbizarre);
        assertEquals(bulbizarre, createdBulbizarre);

        Pokemon createdAquali = pokemonFactory.createPokemon(indexAquali, 2729, 202, 5000, 4);
        assertNotNull(createdAquali);
        assertEquals(aquali, createdAquali);
    }


}

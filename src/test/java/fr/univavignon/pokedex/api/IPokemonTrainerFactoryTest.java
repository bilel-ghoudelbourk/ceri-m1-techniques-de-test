package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {

        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
        pokedexFactory = new PokedexFactory(metadataProvider, pokemonFactory);
        trainerFactory = new PokemonTrainerFactory( metadataProvider, pokemonFactory);
    }

    @Test
    public void createTrainerTest() {
        String trainerName = "Ash";
        Team team = Team.VALOR;
        PokemonTrainer trainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);

        assertNotNull("Le trainer ne devrait pas être null", trainer);
        assertEquals("Le nom du trainer devrait correspondre", trainerName, trainer.getName());
        assertEquals("L'équipe du trainer devrait correspondre", team, trainer.getTeam());

        assertNotNull("Le pokedex du trainer ne devrait pas être null", trainer.getPokedex());
    }
}

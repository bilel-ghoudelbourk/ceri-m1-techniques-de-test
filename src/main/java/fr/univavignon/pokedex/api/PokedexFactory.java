package fr.univavignon.pokedex.api;

/**
 * Factory for creating instances of IPokedex.
 */
public class PokedexFactory implements IPokedexFactory {
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    public PokedexFactory(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        IPokemonMetadataProvider effectiveMetadataProvider = metadataProvider != null ? metadataProvider : this.metadataProvider;
        IPokemonFactory effectivePokemonFactory = pokemonFactory != null ? pokemonFactory : this.pokemonFactory;
        return new Pokedex(effectiveMetadataProvider, effectivePokemonFactory);
    }
}


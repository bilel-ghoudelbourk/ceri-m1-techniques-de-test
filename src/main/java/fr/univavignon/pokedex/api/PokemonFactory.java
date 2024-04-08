package fr.univavignon.pokedex.api;

/**
 * Implementation of the IPokemonFactory interface.
 */
public class PokemonFactory implements IPokemonFactory {

    private IPokemonMetadataProvider metadataProvider;

    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(),cp, hp, dust, candy,0);

        } catch (PokedexException e) {
            throw new RuntimeException("Impossible de récupérer les métadonnées pour le Pokémon d'index " + index, e);
        }
    }
}


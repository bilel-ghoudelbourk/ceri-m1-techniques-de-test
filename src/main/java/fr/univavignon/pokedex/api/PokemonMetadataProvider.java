package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static final List<PokemonMetadata> metadataList = new ArrayList<>();

    static {
        metadataList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        metadataList.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataList.stream()
                .filter(metadata -> metadata.getIndex() == index)
                .findFirst()
                .orElseThrow(() -> new PokedexException("Métadonnées pour Pokémon d'index " + index + " non trouvées."));
    }
}

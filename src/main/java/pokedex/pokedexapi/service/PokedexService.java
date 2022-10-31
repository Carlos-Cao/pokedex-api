package pokedex.pokedexapi.service;

import pokedex.pokedexapi.entity.Pokedex;

import java.util.List;
import java.util.Optional;

public interface PokedexService {

    Pokedex addPokemon(Pokedex pokedex);

    Optional<Pokedex> getPokemonById(String id);

    void deletePokemonById(String id);

    List<Pokedex> getAllPokemon();
}

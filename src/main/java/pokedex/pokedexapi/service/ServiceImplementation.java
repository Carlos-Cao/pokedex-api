package pokedex.pokedexapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pokedex.pokedexapi.entity.Pokedex;
import pokedex.pokedexapi.repository.PokedexRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImplementation implements PokedexService{

    @Autowired
    PokedexRepository repository;

    public ServiceImplementation(PokedexRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pokedex addPokemon(Pokedex pokedex) {
        return repository.save(pokedex);
    }

    @Override
    public Optional<Pokedex> getPokemonById(String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteByPokemonId(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Pokedex> getAllPokemon(List<Pokedex> pokedexList) {
        return repository.findAll();
    }
}

package pokedex.pokedexapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pokedex.pokedexapi.entity.Pokedex;

@Repository
public interface PokedexRepository extends JpaRepository<Pokedex, String> {
}

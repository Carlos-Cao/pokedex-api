package pokedex.pokedexapi.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokedex.pokedexapi.entity.Pokedex;
import pokedex.pokedexapi.service.ServiceImplementation;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
@Log4j2
public class PokedexController {

    @Autowired
    private ServiceImplementation service;

    @PostMapping(path = "/pokemon", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Pokedex> addPokemon(@RequestBody Pokedex pokedex) {
        service.addPokemon(pokedex);
        log.info("{} has been created in the database.", pokedex);
        return ResponseEntity.status(HttpStatus.CREATED).body(pokedex);
    }

    @GetMapping(path = "/pokemon/{id}", produces = "application/json")
    public ResponseEntity<Pokedex> getPokemonById(@PathVariable(value = "id") String id) {
        Optional<Pokedex> record = service.getPokemonById(id);
        if (record.isPresent()) {
            log.info("Pokemon with the Id: {} has been found in the database.", id);
            return ResponseEntity.status(HttpStatus.OK).body(record.get());
        } else {
            log.info("Pokemon with the Id: {} does not exist in the database.", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping(path = "/pokemon/delete/{id}", produces = "application/json")
    public void deletePokemonById(@PathVariable(value = "id") String id) {
        service.deletePokemonById(id);
        log.info("Pokemon with the Id: {} has been deleted from the database.", id);
    }

    @GetMapping(path = "/pokemon/all", produces = "application/json")
    public List<Pokedex> getAllPokemon() {
        log.info("All Pokemon have been listed.");
        return service.getAllPokemon();
    }
}


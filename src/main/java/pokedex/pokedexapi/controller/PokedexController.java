package pokedex.pokedexapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokedex.pokedexapi.entity.Pokedex;
import pokedex.pokedexapi.service.ServiceImplementation;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class PokedexController {

    @Autowired
    private ServiceImplementation service;

    @PostMapping(path = "/pokemon", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Pokedex> addPokemon(@RequestBody Pokedex pokedex) {
        service.addPokemon(pokedex);
        return ResponseEntity.status(HttpStatus.CREATED).body(pokedex);
    }

    @GetMapping(path = "/pokemon/{id}", produces = "application/json")
    public ResponseEntity<Pokedex> getPokemonById(@PathParam("id") String id) {
        Optional<Pokedex> record = service.getPokemonById(id);
        return record.map(pokedex -> ResponseEntity.status(HttpStatus.OK).body(pokedex)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}

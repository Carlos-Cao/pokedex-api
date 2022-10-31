package pokedex.pokedexapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Pokedex {

    @Id
    String id;

    String generation;

    String name;

    String type;

    String ability;

    String height;

    String weight;

    String description;

}

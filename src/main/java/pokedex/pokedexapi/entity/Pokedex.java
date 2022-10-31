package pokedex.pokedexapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Pokedex {

    @Id
    @JsonProperty(value = "Id")
    String id;

    @JsonProperty(value = "Generation")
    String generation;

    @JsonProperty(value = "Name")
    String name;

    @JsonProperty(value = "Type")
    String type;

    @JsonProperty(value = "Ability")
    String ability;

    @JsonProperty(value = "Height")
    String height;

    @JsonProperty(value = "Weight")
    String weight;

    @JsonProperty(value = "Description")
    String description;

}

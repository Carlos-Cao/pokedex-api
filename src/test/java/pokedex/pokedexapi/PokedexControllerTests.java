package pokedex.pokedexapi;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Log4j2
class PokedexControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void pokemonNotFoundTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("http://localhost:8081/v1/pokemon/12345"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
        log.info("Pokemon Id does not exist in the database - passed");
    }

/*	@Test
	void pokemonPostSuccessTest() throws Exception {
		String content = Files.readString(Path.of("src/test/resources/SuccessfulPost.json"));
		this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8081/v1/pokemon/").content(
				"{\n" +
						"  \"Id\": \"1\",\n" +
						"  \"Generation\": \"1\",\n" +
						"  \"Name\": \"Bulbasaur\",\n" +
						"  \"Type\": \"Grass\",\n" +
						"  \"Ability\": \"Overgrow\",\n" +
						"  \"Height\": \"0.7\",\n" +
						"  \"Weight\": \"6.9\",\n" +
						"  \"Description\": \"A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon.\"\n" +
						"}"
		).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
	}*/

    @Test
    void pokemonIdFoundTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8081/v1/pokemon/1")).andDo(print()).andExpect(status().is2xxSuccessful());
        log.info("Pokemon Id 1 has been found - passed");
    }


}

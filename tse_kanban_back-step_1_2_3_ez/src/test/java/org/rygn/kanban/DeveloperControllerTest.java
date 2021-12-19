package org.rygn.kanban;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;






@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(profiles ="test")
public class DeveloperControllerTest extends ControllerTest {
	@Test
	public void testGetDevelopers() throws Exception {
		this.mvc.perform(get("/developers")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].firstname").value("dev1"))
				.andExpect(jsonPath("$[0].lastname", is("dev1")))
				.andExpect(jsonPath("$[0].password", is("dev1")))
				.andExpect(jsonPath("$[0].email", is("dev1@dev.dev")));
				}
	@Test
	public void testGetDeveloper() throws Exception {
		this.mvc.perform(get("/developers/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.firstname", is("dev1")))
				.andExpect(jsonPath("$.lastname", is("dev1")))
				.andExpect(jsonPath("$.password", is("dev1")))
				.andExpect(jsonPath("$.email", is("dev1@dev.dev")));
	}

}
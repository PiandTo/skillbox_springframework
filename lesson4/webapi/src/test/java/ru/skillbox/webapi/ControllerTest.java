package ru.skillbox.webapi;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.skillbox.webapi.model.New.News;
import ru.skillbox.webapi.model.User.User;
import ru.skillbox.webapi.model.User.CreateUserDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Order(1)
	public void postUser() throws Exception {
		CreateUserDto user = new CreateUserDto();
		user.setName("Mikhail");

		String json = objectMapper.writeValueAsString(user);
		mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print()).andExpect(status().isOk());
	}

	@Order(2)
	@Test
	public void getUser() throws Exception {
		News news = new News();
		news.setTitle("Test title news 1");
		news.setText("Test text news 1");
		
		CreateUserDto user = new CreateUserDto();
		user.setName("Mikhail");

		String json = objectMapper.writeValueAsString(user);
		MvcResult result = mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print()).andExpect(status().isOk()).andReturn();
		String resultString = result.getResponse().getContentAsString();
		User readUser = objectMapper.readValue(resultString, User.class);
		// System.out.println(id);
		mockMvc.perform(get("/users/" + readUser.getId())).andDo(print()).andExpect(status().isOk());

		mockMvc.perform(post("/news/" + readUser.getId()).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(readUser)));
	}
}

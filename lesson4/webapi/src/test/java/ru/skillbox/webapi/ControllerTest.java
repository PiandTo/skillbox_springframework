package ru.skillbox.webapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest()
public class ControllerTest {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void postUser() {

	}

}

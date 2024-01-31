package com.boilerplate.springboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class ExampleControllerTest {

	@Autowired
	MockMvc mvc;

	@Test
	public void example_test() throws Exception {
		// given

		// when

		// then
		mvc.perform(get("/example/test"))
			.andExpect(status().isOk())
			.andExpect(content().string("test"));
	}

	@Test
	@DisplayName("DTO 반환 테스트")
	public void hello_test() throws Exception {
		// given
		String name = "myName";
		int amount = 1000;

		// when

		// then
		mvc.perform(get("/example/hello")
			.param("name", name)
			.param("amount", String.valueOf(amount)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value(name))
			.andExpect(jsonPath("$.amount").value(amount));
	}

}

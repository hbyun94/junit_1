package com.hbyun.hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
// JUnit에 내장된 실행자 외에 다른 실행자를 실행시키는데, 여기선 SpringRunner 실행자를 사용. 스프링부터 테스트와 JUnit 사이에 연결자 역할.
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired(required = true)
	private MockMvc mvc;
	
	@Test
	void contextLoads() throws Exception {
		String shouldReturn = "hi there~";
		
		mvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string(shouldReturn));
	}
}

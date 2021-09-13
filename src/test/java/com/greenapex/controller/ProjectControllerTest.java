package com.greenapex.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenapex.model.Project;

@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	ObjectMapper mapper;

	
	@Test
	public void getProject() throws Exception {
		MvcResult mvcResult = mvc.perform(get("/project/findById/1")).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		Project proj = mapper.readValue(content, Project.class);
		assertEquals("AmpApp", proj.getPname());
	}

}

package com.greenapex.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenapex.model.Department;

@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@BeforeEach
	public void adddepartment() throws Exception {
		System.out.println("departmentcontrollertest.adddepartment()");
		this.mockMvc.perform(post("/dept/save")).andDo(print()).andExpect(status().isCreated());
		System.out.println("department save successfully");
	}

	@Test
	public void getDepartment() throws Exception {
		System.out.println("DepartmentControllerTest.getDepartment()");
		MvcResult mvc = this.mockMvc.perform(get("/dept/findByid/52")).andReturn();
		String content = mvc.getResponse().getContentAsString();
		Department d = mapper.readValue(content, Department.class);
		System.out.println("Success : " + content);
		assertEquals("java", d.getDeptName());
		assertEquals("rnc", d.getDeptLocation());
	}

	// @Test
	public void getAll() throws Exception {
		MvcResult mvc = this.mockMvc.perform(get("/detp/getAll")).andReturn();
		String data = mvc.getResponse().getContentAsString();
		mapper.readValue(data, Department.class);
		assertEquals(null, data);
	}
}




















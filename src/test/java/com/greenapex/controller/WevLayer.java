package com.greenapex.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.greenapex.model.Department;
import com.greenapex.service.IDepartmentService;

@WebMvcTest(DepartementController.class)
public class WevLayer {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private IDepartmentService service;

	// @BeforeEach
	public void addDepartment() throws Exception {
		System.out.println("WevLayer.addDepartment()");
		this.mvc.perform(post("/dept/save")).andDo(print()).andExpect(status().isOk());
		System.out.println("dept added");
	}

	
	@Test
	public void getDepartment() throws Exception {
		System.out.println("WevLayer.getDepartment()");
		when(service.findByDeptId(Mockito.anyInt())).thenReturn(new Department(1, "Test", "rnc"));
		MvcResult mvcResult = this.mvc.perform(get("/dept/findByid/1")).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("success: " + content);
		assert (content.isEmpty() == false);
	}

}

package com.greenapex.jsno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.greenapex.controller.DepartementController;
import com.greenapex.model.Department;
import com.greenapex.service.impl.DepartmentServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DepartementController.class)
public class Depttest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentServiceImpl service;

//	Department dept = new Department(1, "java", "rnc");
//
//	
//	String deptJson = "{\"deptName\":\"java\",\"deptLocation\":\"rnc\"}";
//
//	@Test
//	public void addDepartment() throws Exception {
//		Department d = new Department(1, "java", "rnc");
//		Mockito.when(service.saveDept(Mockito.any(Department.class))).thenReturn(dept);
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/dept/save").accept(MediaType.APPLICATION_JSON)
//				.content(deptJson).contentType(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//		assertEquals("http://localhost/dept/save", response.getHeader(HttpHeaders.LOCATION));
//
//	}

}

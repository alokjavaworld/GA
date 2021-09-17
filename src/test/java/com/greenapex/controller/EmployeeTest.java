package com.greenapex.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenapex.model.Employee;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	ObjectMapper mapper;
	
//	DepartmentEntity d=new DepartmentEntity(1,"anything", "anything");
//    
//    ObjectMapper o=new ObjectMapper();
//   
//          mockMvc.perform(post("/api/savedepartment")
//            .contentType("application/json")
//            .content(o.writeValueAsString(d)))
//            .andExpect(status().isO
	
	//Employee emp= new Employee(1,"Alok","emp");
	    
	    //@BeforeEach
	      public void addEmp() throws Throwable, Exception {
	    	  Employee emp= new Employee(1,"Alok","emp");
	    	  ObjectMapper o = new ObjectMapper();
	    	  mvc.perform(post("/emp/save").contentType("application/json").content(o.writeValueAsString(emp)))
	    	  .andExpect(status().isOk());
	    	  System.out.println("Emp Added");
	      }
	
	 
	@Test
	  public void testgetEmpById() throws Exception {
		  MvcResult mvcResult= mvc.perform(get("/emp/findById/1")).andReturn();
		  String data=mvcResult.getResponse().getContentAsString();
		  Employee e =  mapper.readValue(data, Employee.class);
		    assertEquals("alok", e.getEmpName());
		   }
	                                     
}

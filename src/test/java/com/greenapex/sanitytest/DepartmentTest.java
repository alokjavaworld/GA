package com.greenapex.sanitytest;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import com.greenapex.model.Department;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DepartmentTest {

	private int port=8989;
	
	@Autowired
	private TestRestTemplate restTemplet;
	
	//public String BASE_URL= new StringBuilder().append("http://localhost:").append(port).toString();
	 
   @Test
	public void addDepartment() {
		this.restTemplet.postForEntity("http://localhost:8989/dept/save",new Department(1,"ddd","rnc"), String.class);
		assert(this.restTemplet.getForObject("http://localhost:8989/dept/getAll", List.class).size()>1);
	}	
}



package com.greenapex.sanitytest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeApp {
	
	@Test
	public void checkApp() {
		System.out.println("Application Started");
	}

}

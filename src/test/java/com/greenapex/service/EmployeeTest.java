package com.greenapex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import com.greenapex.exception.EmployeeAlreadyExistException;
import com.greenapex.exception.EmployeeNotFoundException;
import com.greenapex.model.Employee;
import com.greenapex.repository.IEmployeeRepo;
import com.greenapex.service.impl.EmployeeImpl;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class EmployeeTest {

	@InjectMocks
	EmployeeImpl servcie;

	@Mock
	IEmployeeRepo repo;

	@BeforeEach
	public void setUpEmploee() {
		when(repo.save(Mockito.any())).thenReturn(createDummyEmp());
        when(repo.findById(Mockito.any())).thenReturn(Optional.of(createDummyEmp()));
	}

	@Test
	public void addEmpTest() throws EmployeeAlreadyExistException {
		Employee emp = servcie.saveEmp(createDummyEmp());
		assertEquals(1, emp.getEmpId());
	}

	@Test
	public void getEmpByIDTest() throws EmployeeNotFoundException {
		Employee emp= servcie.getEmpById(1);
		assertEquals(1, emp.getEmpId());
		assertEquals("Alok",emp.getEmpName());
		assertEquals(null, emp.getDept());
		assertEquals(null,emp.getEmpMgr());
	}
	
	
	public static Employee createDummyEmp() {
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setEmpName("Alok");
		return emp;
	}
	
	
	
	

}

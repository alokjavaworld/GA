package com.greenapex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.greenapex.exception.DepartmentNotFound;
import com.greenapex.model.Department;
import com.greenapex.repository.IDepartmentRepo;
import com.greenapex.service.impl.DepartmentServiceImpl;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DepartmentTest {

	@InjectMocks
	DepartmentServiceImpl service;

	@Mock
	IDepartmentRepo repo;

	@BeforeEach
	public void setUp() {
		when(repo.save(Mockito.any())).thenReturn(createDummyDepartment());
		when(repo.findById(Mockito.any())).thenReturn(Optional.of(createDummyDepartment()));

	}

	@DisplayName("Create Dept Test")
	@Test
	public void testCreateDepartement() throws Exception {
		Department dept = service.saveDept(createDummyDepartment());
		assertEquals(1, dept.getDeptId());
		assertEquals("java", dept.getDeptName());
		assertEquals(null, dept.getDeptLocation());

	}
	
	

	@DisplayName("Get Dept Test")
	@Test
	public void getDepartmentTest() throws DepartmentNotFound {
		Department dept = service.findByDeptId(1);
		//
		assertEquals(1, dept.getDeptId());
		// assertEquals(2, dept.getDeptId());
	}

	public static Department createDummyDepartment() {
		Department testDept = new Department();
		testDept.setDeptId(1);
		testDept.setDeptName("java");  
		return testDept;

	}

}

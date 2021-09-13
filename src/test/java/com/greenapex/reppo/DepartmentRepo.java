package com.greenapex.reppo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.greenapex.model.Department;
import com.greenapex.repository.IDepartmentRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepo {

	@Autowired
	private IDepartmentRepo repo;
//
//	@BeforeEach
//	public void initUseCase() {
//		List<Department> list = new ArrayList<Department>();
//		list.add(new Department(101, "java", "rnc"));
//		list.add(new Department(201, "ui", "rnc"));
//		list.add(new Department(301, "hr", "rnc"));
//		repo.saveAll(list);
//
//	}
//
//	@AfterEach
//	public void destroyAll() {
//		repo.deleteAll();
//	}
//
//	@Test
//	public void saveAll() {
//		List<Department> list = repo.findAll();
//		AtomicInteger validIdFound = new AtomicInteger();
//		list.forEach(e -> {
//			if (e.getDeptId() > 0) {
//				validIdFound.getAndIncrement();
//			}
//		});
//
//		assert (validIdFound.intValue() == 3);
//	}

}

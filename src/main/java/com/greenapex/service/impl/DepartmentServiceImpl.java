package com.greenapex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.greenapex.exception.DepartmentAlreadyExist;
import com.greenapex.exception.DepartmentNotFound;
import com.greenapex.model.Department;
import com.greenapex.repository.IDepartmentRepo;
import com.greenapex.service.IDepartmentService;

@Service
@Primary
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentRepo repo;

	@Override
	public Department saveDept(Department dept) throws DepartmentAlreadyExist {
		Department dep1 = null;
		if (dept.getDeptId() != null) {
			if (repo.existsById(dept.getDeptId())) {
				throw new DepartmentAlreadyExist("Department Already Exist");
			} else
				dep1 = repo.save(dept);
		} else
			dep1 = repo.save(dept);
		return dep1;
	}

	@Override
	public Department findByDeptId(Integer id) throws DepartmentNotFound {
		Department dep = null;
		Optional<Department> opt = repo.findById(id);
		if (opt.isPresent()) {
			dep = opt.get();
		} else
			throw new DepartmentNotFound(" Department Not Found ");
		return dep;
	}

	@Override
	public List<Department> getAllDept() throws DepartmentNotFound {

		// checking record is there or not
		if (repo.count() <= 0)
			throw new DepartmentNotFound(" No Record Found ");
		else
			return repo.findAll();
	}

	
	@Override
	public Department updateDept(Department dept) throws DepartmentNotFound {
		Department dept1 = null;
     System.out.println("DepartmentServiceImpl.updateDept()");
		if (dept.getDeptId() != null && repo.existsById(dept.getDeptId()))
			dept1 = repo.save(dept);
		else
			throw new DepartmentNotFound("Department Not Found For Updation!");
		return dept1;
	}
	
}

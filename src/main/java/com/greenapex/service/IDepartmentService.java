package com.greenapex.service;

import java.util.List;
import com.greenapex.exception.DepartmentAlreadyExist;
import com.greenapex.exception.DepartmentNotFound;
import com.greenapex.model.Department;

public interface IDepartmentService {

	Department saveDept(Department dept) throws DepartmentAlreadyExist;

	Department findByDeptId(Integer id) throws DepartmentNotFound;

	List<Department> getAllDept() throws DepartmentNotFound;

	Department updateDept(Department dept) throws DepartmentNotFound;

}

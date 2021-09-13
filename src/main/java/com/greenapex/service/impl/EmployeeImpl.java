package com.greenapex.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.exception.EmployeeAlreadyExistException;
import com.greenapex.exception.EmployeeNotFoundException;
import com.greenapex.model.Employee;
import com.greenapex.repository.IEmployeeRepo;
import com.greenapex.service.IEmployeeService;


@Service
public class EmployeeImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo repo;

	@Override
	public Employee saveEmp(Employee emp) throws EmployeeAlreadyExistException {
		Employee emp1 = null;
		if (emp.getEmpId() != null) {
			if (repo.existsById(emp.getEmpId())) {
				throw new EmployeeAlreadyExistException(" Employee Already Exist");
			} else
				emp1 = repo.save(emp);
		} else
			emp1 = repo.save(emp);
		return emp1;
	}

	@Override
	public Employee getEmpById(Integer id) throws EmployeeNotFoundException {
		Employee emp;
		Optional<Employee> op = repo.findById(id);
		if (op.isPresent())
			emp = op.get();
		else
			throw new EmployeeNotFoundException("Employee Not Found ");
		return emp;
	}

	@Override
	public List<Employee> getAll() throws EmployeeNotFoundException {

		if (repo.count() <= 0)
			throw new EmployeeNotFoundException("Record Not Found ");
		else
			return repo.findAll();
	}

	@Override
	public Employee updateEmp(Employee emp) throws EmployeeNotFoundException {
		Employee e = null;
		if (emp.getEmpId() != null && repo.existsById(emp.getEmpId()))
			e = repo.save(emp);
		else
			throw new EmployeeNotFoundException("Employee Not Found For Updation");
		return e;
	}

	@Override
	public List<String> getDetails() {
	System.out.println("EmployeeImpl.getDetails()");
	List<String> list = repo.findEmployee();	
	list.forEach(e -> System.out.println(e));
		return list;

	}

	
	@Override
	public List<Employee> findEmpAndDept() {
		List<Employee> listEmp = repo.findEmpAndDeptData();
		listEmp.forEach(e -> System.out.println(e));
		return listEmp;
	}

	@Override
	public List<Employee> findMaxSal() {
		List<Employee> list = repo.findMaxSalByDept();
		list.forEach(e -> System.out.println(e));
		return list;
	}

}

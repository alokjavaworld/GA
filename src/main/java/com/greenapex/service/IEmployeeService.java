package com.greenapex.service;

import java.util.List;
import com.greenapex.exception.EmployeeAlreadyExistException;
import com.greenapex.exception.EmployeeNotFoundException;
import com.greenapex.model.Employee;

public interface IEmployeeService {

	Employee saveEmp(Employee emp) throws EmployeeAlreadyExistException;

	Employee getEmpById(Integer id) throws EmployeeNotFoundException;

	Employee updateEmp(Employee emp) throws EmployeeNotFoundException;

	List<Employee> getAll() throws EmployeeNotFoundException;

	List<String> getDetails();

	List<Employee> findEmpAndDept();

	List<Employee> findMaxSal();

}

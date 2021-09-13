package com.greenapex.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenapex.exception.EmployeeAlreadyExistException;
import com.greenapex.exception.EmployeeNotFoundException;
import com.greenapex.model.Employee;
import com.greenapex.service.IEmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	

	@Autowired
	private IEmployeeService service;


	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp) {
		try {
			return new ResponseEntity(service.saveEmp(emp), HttpStatus.CREATED);
		} catch (EmployeeAlreadyExistException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
		
		
		
		
		
		
		
		
		
	}

	
	@GetMapping("/findByid/{id}")
	public ResponseEntity<Employee> getById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity(service.getEmpById(id), HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}


	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmp() {
	       try {
	    	   return new ResponseEntity(service.getAll(),HttpStatus.OK);
	       }catch (EmployeeNotFoundException e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> update(@RequestBody Employee emp) {
		try {
			return new ResponseEntity(service.updateEmp(emp),HttpStatus.CREATED);
		} catch (EmployeeNotFoundException e) {
		  return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
		}
	
	}
	
	
	// find emp details and there manager
	@GetMapping("/mgr")
	public List<String> getEmpManager() {
		return service.getDetails();
	}

	// find emp and there dept data
	@GetMapping("/find")
	public List<Employee> findEmpAndDept() {
		return service.findEmpAndDept();
	}

	@GetMapping("/findMax")
	public List<Employee> maxSalByDept() {
		return service.findMaxSal();
	}

}

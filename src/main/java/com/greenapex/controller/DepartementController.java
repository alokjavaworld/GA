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

import com.greenapex.exception.DepartmentAlreadyExist;
import com.greenapex.exception.DepartmentNotFound;
import com.greenapex.model.Department;
import com.greenapex.service.IDepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartementController {

	@Autowired
	private IDepartmentService service;
	

	// save
	@PostMapping("/save")
	public ResponseEntity<Department> saveDept(@RequestBody Department dept) {
		System.out.println("DepartementController.saveDept()");
		System.out.println("check devtools");
		try {
			return new ResponseEntity(service.saveDept(dept), HttpStatus.CREATED);
		} catch (DepartmentAlreadyExist e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	
	// find by id and
	@GetMapping("/findByid/{id}")
	public ResponseEntity<Department> getById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity(service.findByDeptId(id), HttpStatus.OK);
		} catch (DepartmentNotFound e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Department>> getAll() {
		System.out.println("DepartementController.getAll()");
		try {
			return new ResponseEntity(service.getAllDept(),HttpStatus.OK);
		} catch (DepartmentNotFound e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
    
	@PutMapping("/update")
	public ResponseEntity<Department> updateDept(@RequestBody Department dept) {
		try {
			return new ResponseEntity(service.updateDept(dept), HttpStatus.CREATED);
		} catch (DepartmentNotFound e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
}

package com.greenapex.controller;

import java.util.List;
import java.util.Optional;

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
import com.greenapex.exception.ProjectAlreadyExist;
import com.greenapex.exception.ProjectNotFoundException;
import com.greenapex.model.Employee;
import com.greenapex.model.Project;
import com.greenapex.service.IProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private IProjectService service;

	// save
	@PostMapping("/save")
	public ResponseEntity<Project> saveProject(@RequestBody Project proj) {
		try {
			return new ResponseEntity(service.save(proj), HttpStatus.CREATED);
		} catch (ProjectAlreadyExist e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	

	// getall
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll() {

		try {
			return new ResponseEntity(service.getAllPoj(), HttpStatus.OK);
		} catch (ProjectNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	

	// find By id
	@GetMapping("/findById/{id}")
	public ResponseEntity<Project> getById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity(service.findByid(id), HttpStatus.OK);
		} catch (ProjectNotFoundException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	// updte
	@PutMapping("/update")
	public ResponseEntity<Project> update(@RequestBody Project proj) {
		try {
			return new ResponseEntity(service.updateProject(proj), HttpStatus.CREATED);
		} catch (ProjectNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/moreProject")
	public List<Project> getEmpMoreThanproj() {
		return service.findEmpMoreProjects();
	}

	
	
	
	
	
	
	
	
	
}

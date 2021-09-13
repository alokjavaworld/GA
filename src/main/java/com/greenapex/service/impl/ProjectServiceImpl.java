package com.greenapex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.exception.ProjectAlreadyExist;
import com.greenapex.exception.ProjectNotFoundException;
import com.greenapex.model.Project;
import com.greenapex.repository.IProjectRepo;
import com.greenapex.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private IProjectRepo repo;

	@Override
	public Project save(Project project) throws ProjectAlreadyExist {
		Project proj1 = null;
		if (project.getPid() != null) {
			if (repo.existsById(project.getPid())) {
				throw new ProjectAlreadyExist(" Project Already Exist");
			} else
				proj1 = repo.save(project);
		} else
			proj1 = repo.save(project);
		return proj1;
	}
	
	
	

	@Override
	public List<Project> getAllPoj() throws ProjectNotFoundException {

		if (repo.count() <= 0)
			throw new ProjectNotFoundException("Record Not Found");
		else
			return repo.findAll();
	}

	@Override
	public Project findByid(Integer id) throws ProjectNotFoundException {
		Project proj;
		Optional<Project> op = repo.findById(id);
		if (op.isPresent())
			proj = op.get();
		else
			throw new ProjectNotFoundException("Project Not Found ");
		return proj;
	}

	
	@Override
	public Project updateProject(Project project) throws ProjectNotFoundException {
		Project p = null;
		if (project.getPid() != null && repo.existsById(project.getPid()))
			p = repo.save(project);
		else
			throw new ProjectNotFoundException("Project Not Found For Updation!");
		return p;
	}
	
	
	@Override
	public List<Project> findEmpMoreProjects() {
		List<Project> list = repo.findEmpMoreThanOneProj();
		list.forEach(e -> System.out.println(e));
		return list;
	}

}

package com.greenapex.service;

import java.util.List;
import com.greenapex.exception.ProjectAlreadyExist;
import com.greenapex.exception.ProjectNotFoundException;
import com.greenapex.model.Project;

public interface IProjectService {

	Project save(Project project) throws ProjectAlreadyExist;

	Project findByid(Integer id) throws ProjectNotFoundException;

	List<Project> getAllPoj() throws ProjectNotFoundException;

	Project updateProject(Project project) throws ProjectNotFoundException;

	List<Project> findEmpMoreProjects();

}

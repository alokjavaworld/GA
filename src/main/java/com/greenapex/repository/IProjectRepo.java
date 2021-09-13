package com.greenapex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greenapex.model.Project;

public interface IProjectRepo extends JpaRepository<Project, Integer> {

	@Query(" SELECT  p , e from Employee e inner join  Project p on e.empId = p.emp.empId"
			+ "    where e.empId in (select emp.empId from Project  GROUP BY emp.empId  HAVING COUNT(emp.empId ) > 1)")
	public List<Project> findEmpMoreThanOneProj();

}
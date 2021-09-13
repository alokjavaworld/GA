package com.greenapex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greenapex.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
//	select e1.emp_name “employees”, e2.emp_name “managers” from 
//	greenapex.emp_tab e1, greenapex.emp_tab e2
//	Where e1.emp_manager=e2.emp_id;
//	
	// @Query("Select empName from Employee ")
	// @Query("from Employee e")
	@Query("select e1.empName  ,e2.empName  from Employee e1"
			+ " , Employee e2 where e1.empMgr=e2.empId")
	public List<String> findEmployee();

	
	@Query(" from  Employee e JOIN  Department d ON e.dept.deptId=d.deptId")
	public List<Employee> findEmpAndDeptData();

	@Query("select e from Employee e where e.empSal IN(Select max(e.empSal) FROM Employee e JOIN Department d "
			+ "ON e.dept.deptId = d.deptId group by d.deptId)")
	public List<Employee> findMaxSalByDept();

	// select e from Employee e where e.empSal IN(Select max(e.empSal) FROM Employee
	// e JOIN Department d ON e.dept.deptId = d.deptId group by d.deptId)

//	@Query("Select empName,empSal  from Employee  Where (dept.deptId,empSal)IN"
//	+ " (Select dept.dept.deptId,Mac(empSal) from Employee GROUP By dept.deptId)")

//	SELECT * FROM greenapex.emp_tab WHERE (dept_id_fk,emp_sal) IN 
//	( SELECT dept_id_fk, MAX(emp_sal) FROM greenapex.emp_tab GROUP BY dept_id_fk)

}

package com.greenapex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenapex.model.Department;

public interface IDepartmentRepo extends JpaRepository<Department, Integer> {

}

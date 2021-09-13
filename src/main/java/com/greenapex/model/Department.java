package com.greenapex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Dept_Tab")
public class Department {

	@Id
	@GeneratedValue(generator = "dept_seq")
	@SequenceGenerator(name = "dept_seq", sequenceName = "dSeq")
	@Column(name = "Dept_Id")
	private Integer deptId;

	@Column(name = "Dept_name")
	private String deptName;

	@Column(name = "Dept_Location")
	private String deptLocation;

	
}

package com.greenapex.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp_tab")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(generator = "emp_seq")
	@SequenceGenerator(name = "emp_seq", sequenceName = "eSeq")
	@Column(name = "EMP_ID")
	private Integer empId;

	@Column(name = "EMP_NAME")
	private String empName;

	@Column(name = "EMP_ROLE")
	private String empRole;

	@Column(name = "EMP_ADDRESS")
	private String empAddress;

	@Column(name = "EMP_SAL")
	private Double empSal;

	@Column(name = "EMP_PHONE")
	private Long phoneNo;

	@Column(name = "EMP_Manager")
	private Integer empMgr;

	@ManyToOne
	@JoinColumn(name = "deptIdFk")
	private Department dept;

	public Employee(Integer empId, String empName, String empRole) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empRole = empRole;
	}
	
	
	

}
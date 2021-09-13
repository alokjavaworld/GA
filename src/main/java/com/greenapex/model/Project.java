package com.greenapex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Project_tab")
public class Project {

	@Id
	@GeneratedValue(generator = "project_seq")
	@SequenceGenerator(name = "project_seq", sequenceName = "pSeq")
	@Column(name = "p_id")
	private Integer pid;

	@Column(name = "p_name")
	private String pname;

	@Column(name = "p_clienName")
	private String clientName;

     @ManyToOne
     @JoinColumn(name = "empIdFk")
      Employee emp;


}

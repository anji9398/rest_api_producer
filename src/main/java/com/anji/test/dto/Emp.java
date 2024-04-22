package com.anji.test.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity
public class Emp {
	
	@Id
	@Column(name = "empno")
	private Integer empId;
	
	@Column(name = "ename")
	private String eName;
	
	@Column(name = "job")
	private String job;
	
	@Column(name = "mgr")
	private Integer mgr;
	
	@Column(name = "hiredate")
	private String hireDate;
	
	@Column(name = "sal")
	private Integer sal;
	
	@Column(name = "comm")
	private Integer comm;
	
	@Column(name = "deptno")
	private Integer deptNo;
	
	
	
	
	
	

}

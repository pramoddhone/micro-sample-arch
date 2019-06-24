package com.nitor.skill.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "RESOURCE")
public class Resource {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long empId;
	
	@Column(name = "EMP_NAME", unique = true, nullable = false, length = 100)
    private String empName;
	
	@Column(name = "MANAGER", unique = false, nullable = false, length = 100)
    private String manager;

	@Column(name = "DEPARTMENT", unique = false, nullable = false, length = 100)
    private String department;
	
	
	@ManyToOne
	@JoinColumn(name = "domainId", nullable = false)
    private Domain domain;
	
	
	public Resource() {
		
	}


	public Resource(long empId, String empName, String manager, String department, Domain domain) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.manager = manager;
		this.department = department;
		this.domain = domain;
	}


	public long getEmpId() {
		return empId;
	}


	public void setEmpId(long empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public Domain getDomain() {
		return domain;
	}


	public void setDomain(Domain domain) {
		this.domain = domain;
	}
}

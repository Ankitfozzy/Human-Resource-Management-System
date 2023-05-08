package com.masai.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name = "password")
    private String password;
    
	@Column(name = "salary", nullable = false)
    private double salary;
    
    @Column(name = "total_leaves")
    private int totalLeaves;
    
    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

	public Employee() {
		super();
	}
	
	
	public Employee(String email, String password, double salary, Department department, int totalLeaves) {
		super();
		this.email = email;
		this.password = password;
		this.salary = salary;
		this.department = department;
		this.totalLeaves = totalLeaves;
	}

	

	public Employee(double salary, String email, boolean isDeleted,
			Department department, int totalLeaves) {
		super();
		this.salary = salary;
		this.totalLeaves = totalLeaves;
		this.email = email;
		this.isDeleted = isDeleted;
		this.department = department;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public int getTotalLeaves() {
		return totalLeaves;
	}



	public void setTotalLeaves(int totalLeaves) {
		this.totalLeaves = totalLeaves;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isDeleted() {
		return isDeleted;
	}



	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}


	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", password=" + password + ", salary=" + salary
				+ ", totalLeaves=" + totalLeaves + ", isDeleted=" + isDeleted + ", department=" + department + "]";
	}


}

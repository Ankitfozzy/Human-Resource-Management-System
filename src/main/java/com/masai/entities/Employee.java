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

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "salary", nullable = false)
    private double salary;
    
    @Column(name = "total_leaves", nullable = false)
    private int totalLeaves;
    
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

	public Employee() {
		super();
	}

	

	public Employee(String firstName, String lastName, double salary, String email, boolean isDeleted,
			Department department, int totalLeaves) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
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



	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", totalLeaves=" + totalLeaves + ", email=" + email + ", isDeleted=" + isDeleted + ", department="
				+ department + "]";
	}


}

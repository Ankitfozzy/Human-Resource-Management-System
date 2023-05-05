package com.masai.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

	@Entity
	public class Department {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name")
	    private String name;

	    @OneToMany(mappedBy = "department")
	    private List<Employee> employees;

		public Department() {
			super();
		}

		public Department(String name, List<Employee> employees) {
			super();
			this.name = name;
			this.employees = employees;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Employee> getEmployees() {
			return employees;
		}

		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}

		@Override
		public String toString() {
			return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
		}
	    
	}


package com.masai.services;

import java.util.List;

import com.masai.entities.Department;

public interface DepartmentService {

	void addDepartment();
	List<Department> viewDepartment();
	Department updateDepartmentName();
	void registerEmployee();
	void changeDepartment();
	void approveLeaveRequest();
	void fireEmployee();
	
}

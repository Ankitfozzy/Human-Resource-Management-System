package com.masai.services;

import java.util.List;

import com.masai.entities.Department;
import com.masai.exceptions.DepartmentNotFound;
import com.masai.exceptions.EmployeeNotFound;
import com.masai.exceptions.SomeThingWentWrongException;

public interface DepartmentService {

	void addDepartment() throws SomeThingWentWrongException;
	List<Department> viewDepartment() throws DepartmentNotFound, SomeThingWentWrongException;
	Department updateDepartmentName() throws DepartmentNotFound, SomeThingWentWrongException;
	void changeDepartment() throws DepartmentNotFound, SomeThingWentWrongException, EmployeeNotFound;
	Department findDepartmentById(long id) throws DepartmentNotFound, SomeThingWentWrongException;
	
}

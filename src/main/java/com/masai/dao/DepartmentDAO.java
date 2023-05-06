package com.masai.dao;

import java.util.List;

import com.masai.entities.Department;
import com.masai.exceptions.DepartmentNotFound;
import com.masai.exceptions.SomeThingWentWrongException;

public interface DepartmentDAO {

	void addDepartment(Department department) throws SomeThingWentWrongException;
	List<Department> getAllDepartments() throws DepartmentNotFound, SomeThingWentWrongException;
	void updateDepartment(Department department) throws DepartmentNotFound, SomeThingWentWrongException;
}

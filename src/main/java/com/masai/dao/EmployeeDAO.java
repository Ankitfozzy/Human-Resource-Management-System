package com.masai.dao;

import com.masai.entities.Employee;
import com.masai.exceptions.EmployeeNotFound;
import com.masai.exceptions.SomeThingWentWrongException;

public interface EmployeeDAO {

	void addEmployee(Employee employee) throws SomeThingWentWrongException, EmployeeNotFound;
	void changeDepartment(Employee employee) throws SomeThingWentWrongException, EmployeeNotFound;
	void approveLeave();
	void deleteEmployee(Employee employee) throws SomeThingWentWrongException, EmployeeNotFound;
	void updateAccount(Employee employee) throws SomeThingWentWrongException, EmployeeNotFound;
	void applyLeave();
	void historyOfLeave();
	Employee getEmployee(String email) throws EmployeeNotFound, SomeThingWentWrongException; 
}

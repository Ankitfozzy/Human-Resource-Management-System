package com.masai.services;

import com.masai.exceptions.DepartmentNotFound;
import com.masai.exceptions.EmployeeNotFound;
import com.masai.exceptions.SomeThingWentWrongException;

public interface EmployeeService {

	boolean employeeLogin(String username, String password);
	void approveLeaveRequest();
	void fireEmployee();
	void registerEmployee() throws DepartmentNotFound, SomeThingWentWrongException, EmployeeNotFound;
	void updateAccountDetails();
	void applyLeave();
	String statusOfLeave();
	String historyOfLeave();
	double  viewMonthSalary();
	void viewAnnualSalary();
	void deleteAccount();
	void logout();
}

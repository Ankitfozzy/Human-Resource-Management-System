package com.masai.services;

public interface EmployeeService {

	void employeeLogin(String username, String password);
	void updateAccountDetails();
	void applyLeave();
	String statusOfLeave();
	String historyOfLeave();
	String  viewMonthSalary();
	String viewAnnualSalary();
	void deleteAccount();
	void logout();
}

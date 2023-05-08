package com.masai.ui;

import java.util.Scanner;

import com.masai.services.EmployeeService;
import com.masai.services.EmployeeServiceImpl;

public class EmployeeUI {

	static EmployeeService employeeService = new EmployeeServiceImpl();
	
	
	static void employeeLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(employeeService.employeeLogin(username, password)) {
			userMenu(sc);
		}
		else {
			System.out.println("Invalid Creditials");
		}
	}
	
	static void displayEmployeeMenu() {
		System.out.println("1. Update the Account Details");
		System.out.println("2. Apply the Leave");
		System.out.println("3. See the status of Leave");
		System.out.println("4. History of Leaves");
		System.out.println("5. See the salary of the month");
		System.out.println("6. See the Annual salary");
		System.out.println("7. Delete the Account");
		System.out.println("0. Logout");
	}
	
	
	static void userMenu(Scanner sc) {
		int choice = 0;
		try {
			do {
				displayEmployeeMenu();
				System.out.print("Enter selection ");
				choice = sc.nextInt();
	    		switch(choice) {
	    			case 1:
	    				employeeService.updateAccountDetails();
	    				break;
	    			case 2:
	    				employeeService.applyLeave();
	    				break;
	    			case 3:
	    				employeeService.statusOfLeave();
	    				break;
	    			case 4:
	    				employeeService.historyOfLeave();
	    				break;
	    			case 5:
	    				double salary = employeeService.viewMonthSalary();
	    				System.out.println(salary);
	    				break;
	    			case 6:
	    				employeeService.viewAnnualSalary();
	    				break;
	    			case 7:
	    				employeeService.deleteAccount();
	    				break;
	    			case 0:
	    				System.out.println("Bye Bye Employee");
	    				return;
	    			default:
	    				System.out.println("Invalid Selection, try again");
	    		}
	    	}while(choice != 0);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
}

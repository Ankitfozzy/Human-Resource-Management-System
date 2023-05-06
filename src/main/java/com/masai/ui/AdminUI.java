package com.masai.ui;

import java.util.Scanner;

import com.masai.services.DepartmentService;
import com.masai.services.DepartmentServiceImpl;

public class AdminUI {
	
	static DepartmentService departmentService = new DepartmentServiceImpl();
	
	
	
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Credentials");
		}
	}
	
	static void displayAdminMenu() {
		System.out.println("1. Add a Department");
		System.out.println("2. View All the Departments");
		System.out.println("3. Update the Department name");
		System.out.println("4. Register a new Employee");
		System.out.println("5. Change the Department of an Employee");
		System.out.println("6. Approve or Deny Leave requests");
		System.out.println("7. Fire an Employee");
		System.out.println("0. Logout");
	}
	
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				addDepartment();
    				break;
    			case 2:
    				viewDepartment();
    				break;
    			case 3:
    				updateDepartmentName();
    				break;
    			case 4:
    				registerEmployee();
    				break;
    			case 5:
    				changeDepartment();
    				break;
    			case 6:
    				approveLeaveRequest();
    				break;
    			case 7:
    				fireEmployee();
    				break;
    			case 0:
    				System.out.println("Bye Bye Admin");
    				return;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	

	
	static void addDepartment() {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		departmentService.addDepartment();
	}
	
	static void viewDepartment() {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		departmentService.viewDepartment();
	}
	
	static void updateDepartmentName() {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		departmentService.updateDepartmentName();
	}

	static void registerEmployee() {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		departmentService.registerEmployee();
	}

	static void changeDepartment() {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		departmentService.changeDepartment();
	}
	
	
	static void approveLeaveRequest() {
		//DepartmentService departmentService = new DepartmentServiceImpl();
		departmentService.approveLeaveRequest();
	}

	static void fireEmployee(){
		//DepartmentService departmentService = new DepartmentServiceImpl();
		departmentService.fireEmployee();
	}
}

package com.masai.ui;

import java.util.Scanner;
import com.masai.services.DepartmentService;
import com.masai.services.DepartmentServiceImpl;

public class Admin 
{
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
			DepartmentService departmentService = new DepartmentServiceImpl();
    		switch(choice) {
    			case 1:
    				departmentService.addDepartment();
    				break;
    			case 2:
    				departmentService.viewDepartment();
    				break;
    			case 3:
    				departmentService.updateDepartmentName();
    				break;
    			case 4:
    				departmentService.registerEmployee();
    				break;
    			case 5:
    				departmentService.changeDepartment();
    				break;
    			case 6:
    				departmentService.approveLeaveRequest();
    				break;
    			case 7:
    				departmentService.fireEmployee();
    				break;
    			case 0:
    				System.out.println("Bye Bye Admin");
    				return;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
	
    public static void main( String[] args ){
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		System.out.println("Welcome to the HR Management System");
    		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    		System.out.println("1. Admin Login");
    		System.out.println("2. Employee Login");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				adminLogin(sc);
    				break;
    			case 0:
    				System.out.println("Thanks for using the services");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();
    }
}

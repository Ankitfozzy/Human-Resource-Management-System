package com.masai.ui;

import java.util.Scanner;

public class App 
{
	
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
    				AdminUI.adminLogin(sc);
    				break;
    			case 2:
    				EmployeeUI.employeeLogin(sc);
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

package com.masai.services;

import java.util.Scanner;

import com.masai.entities.Department;
//import com.masai.entities.Leave;
import com.masai.entities.Employee;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
//import com.masai.dao.LeaveDAO;
//import com.masai.dao.LeaveDAOImpl;
import com.masai.exceptions.DepartmentNotFound;
import com.masai.exceptions.EmployeeNotFound;
import com.masai.exceptions.SomeThingWentWrongException;

public class EmployeeServiceImpl implements EmployeeService {

	static EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public boolean employeeLogin(String username, String password) {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			Employee employee = employeeDAO.getEmployee(username);
			if (employee == null) {
				System.out.println("Employee not found.");
				return false;
			}
			if (password.equals(employee.getPassword()) && !employee.isDeleted()) {
				return true;
			}
		} catch (EmployeeNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateAccountDetails() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("Press 1 to update Username, 2 to update the Password and 3 to update both");
		choice = sc.nextInt();
		System.out.print("Enter existing employee username (email): ");
		String username = sc.next();
		Employee employee = null;
		try {
			employee = employeeDAO.getEmployee(username);
		} catch (EmployeeNotFound | SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (employee == null || employee.isDeleted()) {
			System.out.println("Employee not found.");
			return;
		}
		switch (choice) {
		case 1:
			System.out.println("Enter new Username: ");
			String newUserName = sc.next();
			employee.setEmail(newUserName);
			break;
		case 2: 
			System.out.println("Enter new Password: ");
			String newPassword = sc.next();
			employee.setPassword(newPassword);
			break;
		case 3:
			System.out.println("Enter new Username: ");
			String newUsername = sc.next();
			System.out.println("Enter new Password: ");
			String newPassWord = sc.next();
			employee.setEmail(newUsername);
			employee.setPassword(newPassWord);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		try {
			employeeDAO.updateAccount(employee);
			System.out.println("Account updated succesfully");
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmployeeNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void applyLeave() {
//		Scanner sc = new Scanner(System.in);
//		Leave leave = new Leave();
//		System.out.println("Enter the type of Leave: ");
//		String typeOfLeave = sc.next();
//		System.out.println("Enter the Applicant's Username: ");
//		String applicant = sc.next();
//		leave.setType(typeOfLeave);
//		leave.setApplicant(applicant);
//		leave.setStatus("Pending");
//		LeaveDAO leaveDAO = new LeaveDAOImpl();
//		try {
//			leaveDAO.applyLeave(leave);
//		} catch (SomeThingWentWrongException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public String statusOfLeave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String historyOfLeave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double viewMonthSalary() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee username (email): ");
		String username = sc.next();
		Employee employee = null;
		try {
			employee = employeeDAO.getEmployee(username);
		} catch (EmployeeNotFound | SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		if (employee == null) {
			System.out.println("Employee not found.");
		}
		
		return employee.getSalary();
	}

	@Override
	public void viewAnnualSalary() {
		double salary = viewMonthSalary()*12;
		System.out.println(salary);
	}

	@Override
	public void deleteAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee username (email): ");
		String username = sc.next();
		Employee employee = null;
		try {
			employee = employeeDAO.getEmployee(username);
		} catch (EmployeeNotFound | SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		if (employee == null) {
			System.out.println("Employee not found.");
			return;
		}

		employee.setDeleted(true);

		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			empDAO.deleteEmployee(employee);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmployeeNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Employee deleted successfully.");
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void approveLeaveRequest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fireEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee username (email): ");
		String username = sc.next();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee employee = null;
		try {
			employee = employeeDAO.getEmployee(username);
		} catch (EmployeeNotFound | SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		if (employee == null) {
			System.out.println("Employee not found.");
			return;
		}

		employee.setDeleted(true);

		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			empDAO.deleteEmployee(employee);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmployeeNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Employee deleted successfully.");

	}

	@SuppressWarnings("resource")
	@Override
	public void registerEmployee() throws DepartmentNotFound, SomeThingWentWrongException, EmployeeNotFound {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee username (email): ");
		String username = sc.nextLine();
		System.out.print("Enter employee department ID: ");
		long departmentId = Integer.parseInt(sc.nextLine());
		DepartmentService departmentService = new DepartmentServiceImpl();
		Department department = departmentService.findDepartmentById(departmentId);
		if (department == null) {
			System.out.println("Department not found.");
			return;
		}
		System.out.print("Enter employee salary: ");
		double salary = Double.parseDouble(sc.next());

		Employee employee = new Employee(username, "123456", salary, department, 10);

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.addEmployee(employee);
		sc.close();

		System.out.println("Employee registered successfully.");
	}

}

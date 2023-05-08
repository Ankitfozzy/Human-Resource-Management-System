package com.masai.services;

import java.util.List;
import java.util.Scanner;

import com.masai.entities.Department;
import com.masai.entities.Employee;
import com.masai.exceptions.DepartmentNotFound;
import com.masai.exceptions.EmployeeNotFound;
import com.masai.exceptions.SomeThingWentWrongException;
import com.masai.dao.DepartmentDAO;
import com.masai.dao.DepartmentDAOImpl;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;

public class DepartmentServiceImpl implements DepartmentService{
	
	static DepartmentDAO departmentDAO = new DepartmentDAOImpl();

	@Override
	public void addDepartment() throws SomeThingWentWrongException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Department name: ");
		String departmentName = sc.nextLine();
		
		Department department = new Department(departmentName);
		
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		departmentDAO.addDepartment(department);
		sc.close();
	}

	@Override
	public List<Department> viewDepartment() throws DepartmentNotFound, SomeThingWentWrongException {
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		return departmentDAO.getAllDepartments();
	}

	@Override
	public Department updateDepartmentName() throws DepartmentNotFound, SomeThingWentWrongException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the department Id: ");
		long departmentId = sc.nextLong();
		
		System.out.print("Enter Department name ");
		String departmentName = sc.next();
		sc.close();
		
		Department department = new Department();
		department.setName(departmentName);
		department.setId(departmentId);
		
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		departmentDAO.updateDepartment(department);
		return department;
	}

	@Override
	public void changeDepartment() throws DepartmentNotFound, SomeThingWentWrongException, EmployeeNotFound {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee username (email): ");
	    String username = sc.next();
	    System.out.print("Enter new department ID: ");
	    int departmentId = Integer.parseInt(sc.next());
	    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	    Employee employee = employeeDAO.getEmployee(username);
	    sc.close();
	    if (employee == null) {
	        System.out.println("Employee not found.");
	        return;
	    }
	    Department department = findDepartmentById(departmentId);
	    if (department == null) {
	        System.out.println("Department not found.");
	        return;
	    }
	    
	    employee.setDepartment(department);
	    
	    EmployeeDAO empDAO = new EmployeeDAOImpl();
	    empDAO.changeDepartment(employee);
	    System.out.println("Employee department updated successfully.");
	}


	@Override
	public Department findDepartmentById(long id) throws DepartmentNotFound, SomeThingWentWrongException {
		List<Department> departments = departmentDAO.getAllDepartments();
				
		for (Department department : departments) {
	        if (department.getId() == id) {
	            return department;
	        }
	    }
	    return null;
	}

}

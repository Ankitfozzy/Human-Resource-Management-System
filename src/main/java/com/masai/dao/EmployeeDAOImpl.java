package com.masai.dao;

import java.util.List;

//import com.masai.entities.Department;
import com.masai.entities.Employee;
//import com.masai.exceptions.DepartmentNotFound;
import com.masai.exceptions.EmployeeNotFound;
//import com.masai.exceptions.NoRecordFoundException;
import com.masai.exceptions.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public void addEmployee(Employee employee) throws SomeThingWentWrongException, EmployeeNotFound {
		EntityManager em = EMUtils.getEntityManager();
		try {
			Query query = em.createQuery("SELECT count(e) FROM Employee e WHERE email = :email");
			query.setParameter("email", employee.getEmail());
			if((Long)query.getSingleResult() > 0) {
				throw new SomeThingWentWrongException("Employee already exists with email " + employee.getEmail());
			}
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(employee);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void changeDepartment(Employee employee) throws SomeThingWentWrongException, EmployeeNotFound {
		EntityManager em = EMUtils.getEntityManager();
		try {
			Employee employeeFromDB = em.find(Employee.class, employee.getId());
			if(employeeFromDB == null) {
				throw new EmployeeNotFound("No Employee found with the given id " + employee.getId());
			}
			em.getTransaction().begin();
			em.merge(employee);
			em.getTransaction().commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void approveLeave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee employee) throws SomeThingWentWrongException, EmployeeNotFound {
		EntityManager em = EMUtils.getEntityManager();
		try {
			Employee employeeFromDB = em.find(Employee.class, employee.getId());
			if(employeeFromDB == null) {
				throw new EmployeeNotFound("No Employee found with the given id " + employee.getId());
			}
			em.getTransaction().begin();
			em.merge(employee);
			em.getTransaction().commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}		
	}

	@Override
	public void updateAccount(Employee employee) throws SomeThingWentWrongException, EmployeeNotFound {
		EntityManager em = EMUtils.getEntityManager();
		try {
			Employee employeeFromDB = em.find(Employee.class, employee.getId());
			if(employeeFromDB == null) {
				throw new EmployeeNotFound("No Employee found with the given id " + employee.getId());
			}
			em.getTransaction().begin();
			em.merge(employee);
			em.getTransaction().commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}	
	}

	@Override
	public void applyLeave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void historyOfLeave() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee getEmployee(String email) throws EmployeeNotFound, SomeThingWentWrongException {
		EntityManager em = null;
		List<Employee> employeeList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("FROM Employee e WHERE email = :email");
			query.setParameter("email", email);
			employeeList = (List<Employee>)query.getResultList();
			if(employeeList.size() ==0) {
				throw new EmployeeNotFound("No Employee Found");
			}
		}catch(IllegalArgumentException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		return employeeList.get(0);
	}

	

	

}

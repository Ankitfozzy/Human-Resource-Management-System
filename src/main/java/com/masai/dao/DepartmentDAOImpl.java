package com.masai.dao;

import java.util.List;

import com.masai.entities.Department;
import com.masai.exceptions.DepartmentNotFound;
import com.masai.exceptions.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class DepartmentDAOImpl implements DepartmentDAO{

	@Override
	public void addDepartment(Department department) throws SomeThingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();
		try {
			Query query = em.createQuery("SELECT count(d) FROM Department d WHERE name = :name");
			query.setParameter("name", department.getName());
			if((Long)query.getSingleResult() > 0) {
				throw new SomeThingWentWrongException("Department already exists with name " + department.getName());
			}
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(department);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		
	}

	
	@Override
	public List<Department> getAllDepartments() throws DepartmentNotFound, SomeThingWentWrongException {
	    EntityManager em = EMUtils.getEntityManager();
	    List<Department> departmentList = null;
	    try {
	        TypedQuery<Department> query = em.createQuery("SELECT d FROM Department d", Department.class);
	        departmentList = query.getResultList();
	        
	        if (departmentList.isEmpty()) {
	            throw new DepartmentNotFound("No Department Found");
	        }
	        
	        System.out.println("Total departments: " + departmentList.size());
	    } catch (IllegalArgumentException ex) {
	        throw new SomeThingWentWrongException("Unable to process request, try again later");
	    } finally {
	        em.close();
	    }
	    
	    return departmentList;
	}


	@Override
	public void updateDepartment(Department department) throws DepartmentNotFound, SomeThingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();
		try {
			Department departmentFromDB = em.find(Department.class, department.getId());
			if(departmentFromDB == null)
				throw new DepartmentNotFound("No Department found with the given id " + department.getId());
			if(!departmentFromDB.getName().equals(department.getName())) {
				Query query = em.createQuery("SELECT count(d) FROM Department d WHERE name = :name");
				query.setParameter("name", department.getName());
				if((Long)query.getSingleResult() > 0) {
					throw new SomeThingWentWrongException("Department already exists with name " + department.getName());
				}
			}
			
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			departmentFromDB.setName(department.getName());
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		
	}

}

package com.masai.dao;

import java.util.List;

import com.masai.entities.Department;
import com.masai.exceptions.DepartmentNotFound;
import com.masai.exceptions.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class DepartmentDAOImpl implements DepartmentDAO{

	@Override
	public void addDepartment(Department department) throws SomeThingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
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

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepartments() throws DepartmentNotFound, SomeThingWentWrongException {
		EntityManager em = null;
		List<Department> departmentList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("FROM Department d");
			departmentList = (List<Department>)query.getResultList();
			if(departmentList.size() ==0) {
				throw new DepartmentNotFound("No Department Found");
			}
		}catch(IllegalArgumentException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		return departmentList;
	}

	@Override
	public void updateDepartment(Department department) throws DepartmentNotFound, SomeThingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
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

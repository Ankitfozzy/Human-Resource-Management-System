//package com.masai.dao;
//
//import com.masai.entities.Leave;
//import com.masai.exceptions.SomeThingWentWrongException;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.PersistenceException;
//import jakarta.persistence.Query;
//
//public class LeaveDAOImpl implements LeaveDAO{
//
//	@Override
//	public void applyLeave(Leave leave) throws SomeThingWentWrongException {
//		EntityManager em = EMUtils.getEntityManager();
//		try {
//			EntityTransaction et = em.getTransaction();
//			et.begin();
//			em.persist(leave);
//			et.commit();
//		}catch(PersistenceException ex) {
//			throw new SomeThingWentWrongException("Unable to process request, try again later");
//		}finally{
//			em.close();
//		}
//	}
//
//}

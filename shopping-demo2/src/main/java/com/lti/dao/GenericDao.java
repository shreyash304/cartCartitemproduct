package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class GenericDao {
	
	public String save(Object obj) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();

			tx.begin();
			em.merge(obj);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}		
		return "done";
	}
	
	
	public Object fetch(Class clazz, int pk) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Object obj = em.find(clazz, pk);
			tx.commit();
			return obj;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			em.close();
			emf.close();
		}		
		
	}
	
	
}

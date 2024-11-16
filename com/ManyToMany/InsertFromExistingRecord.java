package com.ManyToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertFromExistingRecord {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
	
		StudentData student3 = new StudentData();
		student3.setId(103);
		student3.setName("Krypto");
		
		Subject s1 =new Subject();
		s1.setId(4);
		s1.setName("React");
		
		Subject s2 = em.find(Subject.class, 1); 
		
		et.begin();
		em.persist(student3);
		em.persist(s1);
//		em.persist(s2);
//		em.persist(s3);
		et.commit();
		
		System.out.println("Records Saved");
		
	}
}

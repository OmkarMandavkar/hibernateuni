package com.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = new Student();
		student.setEmail("krypto@gmail.com");
		student.setName("Zeus");
		student.setPhone(99887766);
		student.setSid(01);

		et.begin();
		em.persist(student);
		et.commit();

		System.out.println("Saved");
	}
}
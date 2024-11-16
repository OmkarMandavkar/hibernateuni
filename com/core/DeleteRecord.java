package com.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteRecord {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Student student = em.find(Student.class, 01);

		if (student != null) {
			em.remove(student);
			et.commit();
			System.out.println("Record Delete Successfully");
		} 
		else {
			System.out.println("Student does not exits");
		}
	}
}
package com.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
	
		et.begin();
		
		Student student = em.find(Student.class, 01);
		
		if(student!= null) {
			System.out.println("Previous Record"+ student);
			student.setPhone(99887744);
			student.setName("Krypto");
			
			em.merge(student);
			
			System.out.println("Update Record"+ student);
			et.commit();
		}
		else {
			System.out.println("Student does not exits");
		}
	}
}
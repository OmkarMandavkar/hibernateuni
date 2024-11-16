package com.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Student student = em.find(Student.class, 01);
		
		System.out.println("--------------------------");
		
		if(student!=null) {
			System.out.println(student);
		}
		else {
			System.out.println("Not found");
		}
		
	}
}
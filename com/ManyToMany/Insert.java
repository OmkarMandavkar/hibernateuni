package com.ManyToMany;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		StudentData student1 = new StudentData();
		student1.setId(101);
		student1.setName("Zeus");
		
		StudentData student2 = new StudentData();
		student2.setId(102);
		student2.setName("Poseidon");
		
		Subject s1 = new Subject();
		s1.setId(1);
		s1.setName("Java");
		
		Subject s2 = new Subject();
		s2.setId(2);
		s2.setName("SQL");
	
		Subject s3 = new Subject();
		s3.setId(3);
		s3.setName("AWS");
		
		
		student1.setSubjects(Arrays.asList(s1,s2));
		student2.setSubjects(Arrays.asList(s1, s2, s3));
		
		et.begin();
		em.persist(student1);
		em.persist(student2);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		et.commit();
		
		System.out.println("Records Saved");
	}
}
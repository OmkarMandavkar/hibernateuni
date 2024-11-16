package com.ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToOne");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product product = new Product();
		product.setPid(101);
		product.setName("Samsung");
		product.setPrice(30000);

		Review r1 = new Review();
		r1.setRid(1);
		r1.setMessage("Good");
		r1.setProduct(product);

		Review r2 = new Review();
		r2.setRid(2);
		r2.setMessage("Battery Not Working");
		r2.setProduct(product);

		Product product2 = new Product();
		product2.setPid(102);
		product2.setName("OnePlus");
		product2.setPrice(30000);

		Review r3 = new Review();
		r3.setRid(3);
		r3.setMessage("Green Line on Screen");
		r3.setProduct(product2);

		et.begin();
		em.persist(product);
		em.persist(r1);
		em.persist(r2);

		em.persist(product2);
		em.persist(r3);
		
		et.commit();
		System.out.println("Records Saved");

	}

}

package com.ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToOne");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Review r1 = em.find(Review.class, 1);
		et.commit();
		
		if(r1!=null) {
			System.out.println("\n\n------    Review    ------");
			System.out.println(r1.getRid());
			System.out.println(r1.getMessage());
			
			System.out.println("------    Product    ------");
			Product product = r1.getProduct();
			System.out.println(product.getPid());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
		}
		else {
			System.out.println("No Data Found");
		}
	}
}

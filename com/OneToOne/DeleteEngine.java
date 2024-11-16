package com.OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteEngine {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOneUni");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		
		Engine e = em.find(Engine.class, 111);
		
		if(e!=null) {
			Car car = em.find(Car.class, 101);
			car.setEngine(null);
			em.merge(car);
			
			em.remove(e);
			et.commit();
			System.out.println("Engine Deleted");
		}
		
		else {
			System.out.println("Not Found");
		}
		
	}
}

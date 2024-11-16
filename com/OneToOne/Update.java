package com.OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOneUni");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Car car = em.find(Car.class, 101);

		if (car != null) {
			System.out.println("Previous Record: " + car);

			car.setBrand("Pagani");

			Engine engine = car.getEngine();
			if (engine != null) {
				engine.setCc(3000);
				em.merge(engine);
			}

			em.merge(car);

			System.out.println("Updated Record: " + car);
			et.commit();
		} else {
			System.out.println("Car does not exist");
		}
	}
}
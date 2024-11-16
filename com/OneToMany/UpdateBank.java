package com.OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateBank {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToMany");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Bank bank = em.find(Bank.class, 101);

		if (bank != null) {
			System.out.println("Previous Record: " + bank);

			bank.setAddress("Powai");
			em.merge(bank);

			System.out.println("Updated Record: " + bank);
			et.commit();
		} else {
			System.out.println("Bank does not exist");
		}
	}
}

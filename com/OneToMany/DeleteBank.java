package com.OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteBank {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToMany");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Bank bank = em.find(Bank.class, 101);

		if (bank != null) {
			em.remove(bank);
			et.commit();
			System.out.println("Bank Deleted");
		} 
		else {
			System.out.println("Bank Not Found");
		}
	}
}

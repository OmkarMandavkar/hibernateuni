package com.OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateAccount {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToMany");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Account account = em.find(Account.class, 112);

		if (account != null) {
			System.out.println("Previous Record: " + account);

			account.setBal(900000);;
			em.merge(account);

			System.out.println("Updated Record: " + account);
			et.commit();
		} 
		else {
			System.out.println("Bank does not exist");
		}
	}
}

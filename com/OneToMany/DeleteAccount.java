package com.OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteAccount {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToMany");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Account account = em.find(Account.class, 111);

		if (account != null) {
			Bank bank = em.find(Bank.class, 101);
			bank.setAccounts(null);
			em.merge(bank);
			
			em.remove(account);
			et.commit();
			System.out.println("Account Deleted");
		} else {
			System.out.println("Account Not Found");
		}

	}
}
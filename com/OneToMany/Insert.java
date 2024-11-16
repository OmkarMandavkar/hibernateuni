package com.OneToMany;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToMany");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bank bank = new Bank();
		bank.setBid(101);
		bank.setName("SBI");
		bank.setAddress("Thane");

		Account a1 = new Account();
		a1.setAccNo(111);
		a1.setName("Dummy");
		a1.setBal(100000);

		Account a2 = new Account();
		a2.setAccNo(112);
		a2.setName("Demo");
		a2.setBal(900000);

		bank.setAccounts(Arrays.asList(a1, a2));

//		Arrays.asList(a1, a2);
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(a1);
//		accounts.add(a2);

		et.begin();
		em.persist(bank);
		em.persist(a1);
		em.persist(a2);
		et.commit();
		System.out.println("Records Saved");
	}
}
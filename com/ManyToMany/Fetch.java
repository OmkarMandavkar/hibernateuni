package com.ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ManyToOne.Product;
import com.OneToMany.Account;

public class Fetch {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		StudentData s1 = em.find(StudentData.class, 102);
		et.commit();

		if (s1 != null) {
			System.out.println("\n\n------    StudentData    ------");
			System.out.println(s1.getId());
			System.out.println(s1.getName());
			System.out.println(s1.getClass());

			List<Subject> sub = s1.getSubjects();
			System.out.println("------------	Subjects	-------------");
			for (Subject subject : sub) {
				System.out.println(subject);
			}
		} else {
			System.out.println("No Data Found");
		}

	}

}

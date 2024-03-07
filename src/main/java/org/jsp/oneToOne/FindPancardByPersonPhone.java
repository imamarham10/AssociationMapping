package org.jsp.oneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPancardByPersonPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Phone");
		long phone = sc.nextLong();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select p.card from Person p where p.phone=?1");
		q.setParameter(1, phone);

		try {
			Pancard c = (Pancard) q.getSingleResult();
			System.out.println(c);
		}catch(NoResultException exp) {
			System.err.println("Invalid credentials");
		}
		sc.close();
	}
}

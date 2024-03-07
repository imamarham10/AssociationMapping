package org.jsp.oneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPancardByPersonId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Id");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select p.card from Person p where p.id=?1");
//		Query q1 = manager.createQuery("select c from Pancard c join Person p where p.id = ?1");
//		q1.setParameter(1, id);
		q.setParameter(1, id);
		
		try {
//			Pancard c1 = (Pancard) q1.getSingleResult();
//			System.out.println(c1);
			Pancard c = (Pancard) q.getSingleResult();
			System.out.println(c);
		}catch(NoResultException exp) {
			System.err.println("Invalid credentials");
		}
		sc.close();
	}
}

package org.jsp.ManyToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter answer:");
		String answer = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();


		Query q = manager.createQuery("select a from Answer a from answer=?1");
		q.setParameter(1, answer);

		try {
			Answer a = (Answer) q.getSingleResult();
			System.out.println(a);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

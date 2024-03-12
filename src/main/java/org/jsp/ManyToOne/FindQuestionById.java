package org.jsp.ManyToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FindQuestionById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter question id:");
		int id = sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();


		Query q = manager.createQuery("select q from Question q where q.id = ?1");
		q.setParameter(1, id);

		try {
			Question m = (Question) q.getSingleResult();
			System.out.println(m);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

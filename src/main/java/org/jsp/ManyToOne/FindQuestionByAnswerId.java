package org.jsp.ManyToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindQuestionByAnswerId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter answer id:");
		int id = sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();


		Query q = manager.createQuery("select a.question from Answer a where a.id = ?1");
		q.setParameter(1, id);

		try {
			Question question = (Question) q.getSingleResult();
			System.out.println(question);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

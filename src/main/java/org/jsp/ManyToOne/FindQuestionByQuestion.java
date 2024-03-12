package org.jsp.ManyToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindQuestionByQuestion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter question:");
		String question = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();


		Query q = manager.createQuery("select q from Question q where question = ?1");
		q.setParameter(1, question);

		try {
			Question ques = (Question) q.getSingleResult();
			System.out.println(ques);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

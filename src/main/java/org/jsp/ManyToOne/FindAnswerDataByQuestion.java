package org.jsp.ManyToOne;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataByQuestion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter question:");
		String question = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();


		Query q = manager.createQuery("select a from Answer a where a.question.question = ?1");
		q.setParameter(1, question);

		List<Answer>answers = q.getResultList();
		if(answers.size()>0) {
			for(Answer a:answers) {
				System.out.println(a);
			}
		}else {
			System.out.println("No answers present for the question");
		}
	}
}

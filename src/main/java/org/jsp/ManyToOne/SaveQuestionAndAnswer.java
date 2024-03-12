package org.jsp.ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveQuestionAndAnswer {
	public static void main(String[] args) {
		Question q = new Question();
		q.setQuestion("What is Hibernate?");
		q.setPostedBy("Satish Yadav");
		
		Answer a1 = new Answer();
		a1.setAnswer("It is an open source framework");
		a1.setAnsweredBy("Prem");
		a1.setQuestion(q);
		
		Answer a2 = new Answer();
		a2.setAnswer("It is non-invasive framework");
		a2.setAnsweredBy("Jatin");
		a2.setQuestion(q);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction t = manager.getTransaction();
		manager.persist(a1);
		manager.persist(a2);
		t.begin();
		t.commit();
	}
}

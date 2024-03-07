package org.jsp.oneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class FindPancardById {
public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	
	
	try {
		Pancard card = manager.find(Pancard.class, 1);
		System.out.println(card);
	}catch(NoResultException exp) {
		System.err.println("Invalid id");
	}
}
}

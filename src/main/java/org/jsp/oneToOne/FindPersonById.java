package org.jsp.oneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class FindPersonById {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		
		try {
			Person p = manager.find(Person.class, 1);
			System.out.println(p);
		}catch(NoResultException exp) {
			System.err.println("Invalid id");
		}
	}
}

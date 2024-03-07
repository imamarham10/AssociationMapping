package org.jsp.oneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select p from Person p where name=?1");
		q.setParameter(1, name);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println(p);
		}catch(NoResultException exp) {
			System.err.println("Invalid credentials");
		}
		sc.close();
	}
}

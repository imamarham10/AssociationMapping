package org.jsp.oneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPancardId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Pancard Id");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

//		Query q = manager.createQuery("select p from Person p join Pancard c on c.id=?1");
		Query q = manager.createQuery("select p from Person p where p.card.id=?1");
		q.setParameter(1, id);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println(p);
		}catch(NoResultException exp) {
			System.err.println("Invalid credentials");
		}
		sc.close();
	}
}

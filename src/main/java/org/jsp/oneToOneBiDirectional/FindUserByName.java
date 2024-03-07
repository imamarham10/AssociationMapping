package org.jsp.oneToOneBiDirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user name:-");
		String name = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select u from User u where name=?1");
		q.setParameter(1, name);

		try {
			User u = (User) q.getSingleResult();
			System.out.println(u);
		}catch(NoResultException e) {
			System.err.println("Invalid id!");
		}
	}
}

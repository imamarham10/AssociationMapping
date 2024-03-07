package org.jsp.oneToOneBiDirectional;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user id:-");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select c from Aadharcard c where c.user.id=?1");
		q.setParameter(1, id);

		try {
			Aadharcard c = (Aadharcard)q.getSingleResult();
			System.out.println(c);
		}catch(NoResultException e) {
			System.err.println("Invalid id!");
		}
	}
}

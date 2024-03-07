package org.jsp.oneToOneBiDirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user phone:-");
		long phone = sc.nextLong();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select c from Aadharcard c where c.user.phone=?1");
		q.setParameter(1, phone);

		try {
			Aadharcard c = (Aadharcard)q.getSingleResult();
			System.out.println(c);
		}catch(NoResultException e) {
			System.err.println("Invalid id!");
		}
	}
}

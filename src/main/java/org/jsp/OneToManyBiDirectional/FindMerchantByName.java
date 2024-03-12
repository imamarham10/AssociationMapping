package org.jsp.OneToManyBiDirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product name:");
		String name = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();


		Query q = manager.createQuery("select m from Merchant m where m.name = ?1");
		q.setParameter(1, name);

		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

package org.jsp.OneToManyBiDirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyMerchantByPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter merchant phone:");
		long phone = sc.nextLong();
		System.out.println("Enter merchant password");
		String password = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();


		Query q = manager.createQuery("select m from Merchant m where m.phone = ?1 and m.password = ?2");
		q.setParameter(1,phone);
		q.setParameter(2, password);

		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

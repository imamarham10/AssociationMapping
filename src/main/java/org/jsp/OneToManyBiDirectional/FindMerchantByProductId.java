package org.jsp.OneToManyBiDirectional;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByProductId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product id:");
		int id = sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();


		Query q = manager.createQuery("select p.merchant from Product p where p.id = ?1");
		q.setParameter(1, id);

		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

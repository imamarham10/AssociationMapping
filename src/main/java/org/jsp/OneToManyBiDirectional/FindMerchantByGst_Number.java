package org.jsp.OneToManyBiDirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByGst_Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product gst_number:");
		String gst_number = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();


		Query q = manager.createQuery("select m from Merchant m where m.gst_number = ?1");
		q.setParameter(1, gst_number);

		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

package org.jsp.ManyToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchByBatchCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch code:");
		String bCode = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select b from Batch b where batchCode = ?1");
		q.setParameter(1, bCode);

		try {
			Batch b = (Batch)q.getSingleResult();
			System.out.println(b);

		}catch(NoResultException exp) {
			System.err.println(exp);
		}

	}
}

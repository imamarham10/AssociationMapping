package org.jsp.OneToManyBiDirectional;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product id");
		int id= sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		
		Query q = manager.createQuery("select p from Product p where p.id=?1");
		q.setParameter(1,id);
		
		try {
			Product p = (Product)q.getSingleResult();
			System.out.println(p);
		}catch(NoResultException exp) {
			System.out.println(exp);
		}
	}
}

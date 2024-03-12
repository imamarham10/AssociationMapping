package org.jsp.OneToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeeByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Name");
		String name = sc.next();	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select d from Employee d where name=?1");
		q.setParameter(1,name);

		try {
			Employee d = (Employee) q.getSingleResult();
			System.out.println(d);
		}catch(NoResultException exp) {
			System.err.println("Invalid Employee name");
		}
		sc.close();
	}
}

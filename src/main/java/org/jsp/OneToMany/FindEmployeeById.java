package org.jsp.OneToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeeById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select e from Employee e where id=?1");
		q.setParameter(1, id);

		try {
			Employee e = (Employee) q.getSingleResult();
			System.out.println(e);
		}catch(NoResultException exp) {
			System.err.println("Invalid Department id");
		}
		sc.close();
	}
}

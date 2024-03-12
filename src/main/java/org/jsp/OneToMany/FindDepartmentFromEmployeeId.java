package org.jsp.OneToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.oneToOne.Pancard;

public class FindDepartmentFromEmployeeId {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Employee Id");
	int id = sc.nextInt();

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();

	Query q = manager.createQuery("select e from  p where p.id=?1");
	q.setParameter(1, id);
	
	try {
//		Pancard c1 = (Pancard) q1.getSingleResult();
//		System.out.println(c1);
		Pancard c = (Pancard) q.getSingleResult();
		System.out.println(c);
	}catch(NoResultException exp) {
		System.err.println("Invalid credentials");
	}
	sc.close();
}
}

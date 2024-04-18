package org.jsp.ManyToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student name:");
		String name = sc.next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select s from Student s where s.name = ?1");
		q.setParameter(1, name);
		
		try {
			Student s = (Student) q.getSingleResult();
			System.out.println(s);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

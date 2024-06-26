package org.jsp.ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student id:");
		int id = sc.nextInt();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select s from Student s where s.id = ?1");
		q.setParameter(1, id);
		
		try {
			Student s = (Student) q.getSingleResult();
			System.out.println(s);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

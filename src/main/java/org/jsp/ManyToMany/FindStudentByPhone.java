package org.jsp.ManyToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentByPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student phone:");
		long phone = sc.nextLong();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select s from Student s where s.phone = ?1");
		q.setParameter(1, phone);
		
		try {
			Student s = (Student) q.getSingleResult();
			System.out.println(s);
		}catch(NoResultException exp) {
			System.err.println(exp);
		}
	}
}

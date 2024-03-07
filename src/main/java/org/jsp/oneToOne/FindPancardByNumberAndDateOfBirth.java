package org.jsp.oneToOne;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPancardByNumberAndDateOfBirth {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Pancard Number");
	String number = sc.next();
	System.out.println("Enter Date of birth");
	LocalDate dob = LocalDate.parse(sc.next());

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();

	Query q = manager.createQuery("select c from Pancard c where number=?1 and dob=?2");
	q.setParameter(1, number);
	q.setParameter(2, dob);
	try {
		Pancard card = (Pancard) q.getSingleResult();
		System.out.println(card);
	}catch(NoResultException exp) {
		System.err.println("Invalid credentials");
	}
	sc.close();
}
}

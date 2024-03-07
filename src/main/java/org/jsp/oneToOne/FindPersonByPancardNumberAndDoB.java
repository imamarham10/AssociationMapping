package org.jsp.oneToOne;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPancardNumberAndDoB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Pancard Number");
		String number = sc.next();
		System.out.println("Enter date of birth");
		LocalDate dob = LocalDate.parse(sc.next());

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

//		Query q = manager.createQuery("select p from Person p join Pancard c on c.number=?1 and c.dob=?2");
		Query q = manager.createQuery("select p from Person p where p.card.number=?1 and p.card.dob=?2");
		q.setParameter(1,number);
		q.setParameter(2, dob);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println(p);
		}catch(NoResultException exp) {
			System.err.println("Invalid credentials");
		}
		sc.close();
	}
}

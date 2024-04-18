package org.jsp.ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FilterStudentBetweenPercRange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter lower limit:");
		double lPerc = sc.nextDouble();
		System.out.println("Enter upper limit:");
		double uPerc = sc.nextDouble();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select s from Student s where s.perc between ?1 and ?2");
		q.setParameter(1, lPerc);
		q.setParameter(2, uPerc);
		List<Student> stds = q.getResultList();
		if(stds.size()>0) {
			for(Student s : stds) {
				System.out.println(s);
			}
		}else {
			System.out.println("No student has secured percentage above 35");
		}
		
	}
}

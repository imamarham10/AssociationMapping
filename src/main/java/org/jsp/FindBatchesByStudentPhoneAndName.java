package org.jsp.ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchesByStudentPhoneAndName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student phone:");
		long phone = sc.nextLong();
		System.out.println("Enter student name:");
		String name = sc.next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select s.batches from Student s where s.phone = ?1 and s.name=?2");
		q.setParameter(1, phone);
		q.setParameter(2, name);
		
		List<Batch>batches = q.getResultList();
		if(batches.size()>0) {
			for(Batch b : batches) {
				System.out.println(b);
			}
		}else {
			System.out.println("No batch alotted to the student with phone"+ phone);
		}
	}
}

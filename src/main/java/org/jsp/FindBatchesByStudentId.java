package org.jsp.ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchesByStudentId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student id:");
		int id = sc.nextInt();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select s.batches from Student s where s.id = ?1");
		q.setParameter(1, id);
		
		List<Batch>batches = q.getResultList();
		if(batches.size()>0) {
			for(Batch b : batches) {
				System.out.println(b);
			}
		}else {
			System.out.println("No batch alotted to the student with id"+ id);
		}

	}
}

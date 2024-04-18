package org.jsp.ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentByBatchCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch code:");
		String bCode = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select b.students from Batch b where b.batchCode=?1");
		q.setParameter(1, bCode);
		List<Student> stds = q.getResultList();
		if(stds.size()>0) {
			for(Student s : stds) {
				System.out.println(s);
			}
		}else {
			System.out.println("No student is registered in batch");
		}
	}
}

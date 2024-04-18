package org.jsp.ManyToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch id:");
		int id = sc.nextInt();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Batch b = manager.find(Batch.class, id);
		if(b!=null) {
			System.out.println(b);
		}else {
			System.err.println("Invalid Credentials");
		}
	}
}

package org.jsp.ManyToMany;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveBatchAndStudent {
	public static void main(String[] args) {
		Batch b1 = new Batch();
		b1.setBatchCode("JAV-A11");
		b1.setSubject("JAVA");
		b1.setTrainer("Keshav");
		
		Batch b2 = new Batch();
		b2.setBatchCode("JDBC-A11");
		b2.setSubject("JDBC");
		b2.setTrainer("Gururaja");
		
		Batch b3 = new Batch();
		b3.setBatchCode("HIB-A11");
		b3.setSubject("Hibernate");
		b3.setTrainer("Satish");
		
		Student s1 = new Student();
		s1.setName("Ronaldo");
		s1.setPhone(789456123L);
		s1.setPerc(87.78);
		
		Student s2 = new Student();
		s2.setName("Sunil");
		s2.setPhone(456123079L);
		s2.setPerc(56.78);
		
		
		Student s3 = new Student();
		s3.setName("Messi");
		s3.setPhone(789200123L);
		s3.setPerc(87.78);
		
		
		b1.setStudents(Arrays.asList(s1,s2,s3));
		b2.setStudents(Arrays.asList(s1,s3));
		b3.setStudents(Arrays.asList(s2,s3));
		
		s1.setBatches(Arrays.asList(b1,b2));
		s2.setBatches(Arrays.asList(b1,b3));
		s3.setBatches(Arrays.asList(b1,b2,b3));
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction t = manager.getTransaction();
		
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		t.begin();
		t.commit();
		
		
		
	}
}

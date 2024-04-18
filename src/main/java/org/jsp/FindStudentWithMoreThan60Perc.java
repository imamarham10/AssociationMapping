package org.jsp.ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentWithMoreThan60Perc {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select s from Student s where s.perc>=60");
		List<Student> stds = q.getResultList();
		if(stds.size()>0) {
			for(Student s : stds) {
				System.out.println(s);
			}
		}else {
			System.out.println("No student has secured percentage above 60");
		}
	}
}

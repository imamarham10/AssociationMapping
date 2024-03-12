package org.jsp.OneToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeesByDepartmentIdAndLocation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Id");
		int id = sc.nextInt();
		System.out.println("Enter Department Location");
		String location = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select d.emps from Department d where d.id=?1 and d.location=?2");
		q.setParameter(1, id);
		q.setParameter(2, location);
		
		List<Employee> emps = q.getResultList();
		
		if(emps.size()>0) {
			for(Employee e: emps) {
				System.out.println(e);
			}
		}else {
			System.out.println("No employee present in entered department id");
		}
		sc.close();
	}
}

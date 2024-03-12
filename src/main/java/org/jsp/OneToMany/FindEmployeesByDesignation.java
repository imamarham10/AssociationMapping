package org.jsp.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeesByDesignation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Designation");
		String designation = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select e from Employee e where designation=?1");
		q.setParameter(1, designation);

		List<Employee>emps = new ArrayList<Employee>();
		if(emps.size()>0) {
			for(Employee d : emps) {
				System.out.println(d);
			}
		}else {
			System.out.println("No employees present with this designation.");
		}
		sc.close();
	}
}

package org.jsp.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeesBySalary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Salary");
		double salary = sc.nextDouble();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select e from Employee e where salary=?1");
		q.setParameter(1, salary);

		List<Employee>emps = new ArrayList<Employee>();
		if(emps.size()>0) {
			for(Employee d : emps) {
				System.out.println(d);
			}
		}else {
			System.out.println("No employee has this salary.");
		}
		sc.close();
	}
}

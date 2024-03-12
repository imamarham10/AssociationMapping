package org.jsp.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindDepartmentByLocation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Depatment Location");
		String location = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select d from Department d where location=?1");
		q.setParameter(1, location);

		List<Department>depts = new ArrayList<Department>();
		if(depts.size()>0) {
			for(Department d : depts) {
				System.out.println(d);
			}
		}else {
			System.out.println("No departments present at this location.");
		}
		sc.close();
	}
}

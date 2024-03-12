package org.jsp.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SaveDepartmentAndEmployees {
	public static void main(String[] args) {
		Department d = new Department();
		d.setName("Development");
		d.setLocation("Bengaluru");
		
		Employee e1 = new Employee();
		e1.setName("ABC");
		e1.setDesg("Trainee");
		e1.setSalary(20000);
		Employee e2 = new Employee();
		e2.setName("EFG");
		e2.setDesg("Web Developer");
		e2.setSalary(60000);
		Employee e3 = new Employee();
		e3.setName("XYZ");
		e3.setDesg("Product Manager");
		e3.setSalary(45000);
		
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		
		d.setEmps(emps);
//		d.setEmps(Arrays.asList(e1,e2,e3));
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction t = manager.getTransaction();
		
		manager.persist(d);
		t.begin();
		t.commit();
		
	}
}

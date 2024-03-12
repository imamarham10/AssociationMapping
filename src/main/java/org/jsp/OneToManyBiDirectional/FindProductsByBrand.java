package org.jsp.OneToManyBiDirectional;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductsByBrand {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product brand");
		String brand = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		
		Query q = manager.createQuery("select p from Product p where p.brand=?1");
		q.setParameter(1,brand);
		
		List<Product> products = q.getResultList();
		if(products.size()>0) {
			for(Product p: products) {
				System.out.println(p);
			}
		}else {
			System.err.println("No result found!");
		}
	}
}

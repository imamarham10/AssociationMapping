package org.jsp.OneToManyBiDirectional;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductsByMerchantPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter merchant phone:");
		long phone = sc.nextLong();
		System.out.println("Enter merchant password");
		String password = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		
		Query q = manager.createQuery("select m.products from Merchant m where m.phone = ?1 and m.password = ?2");
		q.setParameter(1,phone);
		q.setParameter(2, password);
		
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

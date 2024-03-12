package org.jsp.OneToManyBiDirectional;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductsByMerchantIdAndGst {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter merchant id:");
		int id = sc.nextInt();
		System.out.println("Enter merchant gst_number");
		String gst_number = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();


		Query q = manager.createQuery("select m.products from Merchant m where m.id = ?1 and m.gst_number = ?2");
		q.setParameter(1,id);
		q.setParameter(2, gst_number);

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

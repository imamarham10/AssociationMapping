package org.jsp.OneToManyBiDirectional;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchantAndProducts {
	public static void main(String[] args) {
		Merchant m = new Merchant();
		m.setName("Deku");
		m.setPhone(5566699L);
		m.setGst_number("deku132330");
		m.setPassword("deku@123");
		
		Product p1 = new Product();
		p1.setBrand("Samsung");
		p1.setCategory("Mobile");
		p1.setCost(35000);
		p1.setDescription("smartphone 6GB");
		p1.setName("Mobile");
		p1.setMerchant(m);
		
		
		Product p2 = new Product();
		p2.setBrand("Lenovo");
		p2.setCategory("Laptops");
		p2.setCost(65000);
		p2.setDescription("12GB ram");
		p2.setName("Laptop");
		p2.setMerchant(m);
		
		m.setProducts(Arrays.asList(p1,p2));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction t = manager.getTransaction();
		manager.persist(m);
		t.begin();
		t.commit();

	}
}

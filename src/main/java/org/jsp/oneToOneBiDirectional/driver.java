package org.jsp.oneToOneBiDirectional;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class driver {
	public static void main(String[] args) {
		User user = new User();
		user.setName("Arnav");
		user.setPhone(7894561230L);
		
		Aadharcard card = new Aadharcard();
		card.setNumber(221366868686L);
		card.setDob(LocalDate.parse("2000-10-20"));
		card.setAddress("Brouge Avenue, Los Santos");
		
		user.setCard(card);
		card.setUser(user);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction t = manager.getTransaction();
		
		manager.persist(user);
		t.begin();
		t.commit();
	}
}

package org.jsp.oneToOne;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonAndPancard {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction t = manager.getTransaction();
		
		Person p = new Person();
		p.setName("Arnav");
		p.setPhone(7894561230L);
		
		Pancard card = new Pancard();
		card.setNumber("AIARP7890E");
		card.setDob(LocalDate.parse("1947-08-15"));
		card.setPincode(233001);
		
		
		p.setCard(card);
		manager.persist(p);
		manager.persist(card);
		
		t.begin();
		t.commit();
	}
}

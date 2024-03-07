package org.jsp.oneToOneBiDirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false, unique=true)
	private long phone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "card")
	private Aadharcard card;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Aadharcard getCard() {
		return card;
	}

	public void setCard(Aadharcard card) {
		this.card = card;
	}
}

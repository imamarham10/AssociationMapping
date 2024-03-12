package org.jsp.OneToManyBiDirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String brand, description, category, name;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false)
	private double cost;


	@JoinColumn()
	@ManyToOne(cascade=CascadeType.ALL)
	private Merchant merchant;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public Merchant getMerchant() {
		return merchant;
	}


	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", description=" + description + ", category=" + category
				+ ", name=" + name + ", cost=" + cost + "]";
	}


}

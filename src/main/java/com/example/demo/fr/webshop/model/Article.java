package com.example.demo.fr.webshop.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "articles")
public class Article {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 30)
	@NotNull
	private String description;

	@Size(max = 30)
	private String brand;

	@Column(name = "unitaryPrice")
	private Float unitaryPrice;
	
	
	
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Float getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(Float unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}
	
	
}

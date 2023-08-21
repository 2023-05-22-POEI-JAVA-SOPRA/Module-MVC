package fr.maboite.webshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity @Table
public class Article {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id_article")
	private Long idArticle;
	
	@Size(max=30)@NotEmpty
	private String description;
	
	@Size(max=30)@NotEmpty
	private String brand;
	
	@Column(name="unitary_price")@NotNull
	private Float unitaryPrice;

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
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
	

	public Article(String description,String brand,Float unitaryPrice) {
		super();
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}

	public Article() {
		super();
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", description=" + description + ", brand=" + brand
				+ ", unitaryPrice=" + unitaryPrice + "]";
	}
	
	
	
}

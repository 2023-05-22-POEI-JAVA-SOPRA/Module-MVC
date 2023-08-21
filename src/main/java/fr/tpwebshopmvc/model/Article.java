package fr.tpwebshopmvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name="T_Articles")
public class Article {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="idarticle")
	private Integer idArticle;
	
	private String description;
	private String brand;
	@Column(name="unitaryprice")
	private double unitaryPrice;
	
	public Integer getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Integer idArticle) {
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
	public double getUnitaryPrice() {
		return unitaryPrice;
	}
	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}
	public Article(String description, String brand, double unitaryPrice) {
	
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}
	public Article() {

	}
	
	
}


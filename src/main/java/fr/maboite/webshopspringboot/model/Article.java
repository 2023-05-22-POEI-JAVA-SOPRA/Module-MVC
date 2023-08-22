package fr.maboite.webshopspringboot.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Article")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	//@Column(name = "id")
	private Integer id;
	
	@Size(max=30)
	private String description;
	
	@Size(max=30)
	private String brand;

	
	@NotNull @Column(name = "unitaryprice")
	private float unitaryPrice;

	public int getId() {
		return id;
	}

	public void setId(int articleId) {
		this.id = articleId;
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

	public float getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(float unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public Article(int id, String description, String brand,
			float unitaryPrice) {
		
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}
	
	

	public Article() {
		super();
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", description=" + description + ", brand=" + brand + ", unitaryPrice="
				+ unitaryPrice + "]";
	}
	
	


	

	
	
	

}

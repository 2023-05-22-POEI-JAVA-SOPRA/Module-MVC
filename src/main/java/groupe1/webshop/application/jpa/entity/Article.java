package groupe1.webshop.application.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_Articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArticle;
	
	// VERIFIER SI CONFLITS AVEC REGLES BDD
	@Size(max=30, message="La description doit faire 30 caracteres max")
	@NotNull
	private String description;
	
	@Size(max=30, message="La marque doit faire 30 caracteres max")
	@NotNull
	private String brand;

	@Column(name="unitaryPrice")
	@NotNull(message="Le prix ne peut pas être nul")
	private Float price;
	
	private static final Double maxPrice = 500.00;

	public static Double getMaxprice() {
		return maxPrice;
	}

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

	public Float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", description=" + description + ", brand=" + brand + ", price="
				+ price + "]";
	}

}

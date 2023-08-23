package groupe1.webshop.application.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_Articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArticle;
	
	// VERIFIER SI CONFLITS AVEC REGLES BDD
	@Size(min=3,max=30, message="La description doit faire 3 caractères min et 30 caracteres max")
	@NotNull
	private String description;
	
	@Size(max=30, message="La marque doit faire 30 caracteres max")
	@NotNull
	private String brand;

	@Column(name="unitaryPrice")
	@Positive(message="Le prix ne peut pas être négatif ou nul")
	private Float price;
	
	private static final Double maxPrice = 500.00;

	/**
	 * @return
	 */
	public static Double getMaxprice() {
		return maxPrice;
	}

	/**
	 * @return
	 */
	public Integer getIdArticle() {
		return idArticle;
	}

	/**
	 * @param idArticle
	 */
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", description=" + description + ", brand=" + brand + ", price="
				+ price + "]";
	}

}

package groupe1.webshop.application.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "T_Roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Positive(message = "L'id doit etre STRICTEMENG positif")
	private Integer idRole;

	@NotEmpty(message = "L'attribut nom ne peut être vide")
	@NotNull(message = "L'attribut nom est null")
	@Size(min=3,max = 20, message = "Le nom ne doit pas dépasser 20 caractères")
	@Column(name = "roleName")
	private String name;

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package groupe1.webshop.application.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
@Entity
@Table(name = "T_Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Positive(message="L'id doit etre STRICTEMENG positif")
	private Integer idUser;

//	@Email(message="Le login doit etre un email")
	@NotEmpty(message="Le login doit exister (non vide soit 1 car minimum)")
	@Size(max = 20, message="Le login doit faire 20 caracteres max")
	@NotNull
	private String login;

	@NotEmpty
	@Size(max = 20, message="Mot de passe 20 caracteres max")
	@NotNull
	private String password;

	@NotNull(message="Le numéro de connexion ne peut être nul.")
	@Max(value=100000, message="Le numéro de connexion ne peut être supérieur à 100000")
	@Positive(message="Le numéro de connexion doit être strictement positif")
	private Integer connectionNumber;

	/**
	 * @return
	 */
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getConnectionNumber() {
		return connectionNumber;
	}

	/**
	 * @param connectionNumber
	 */
	public void setConnectionNumber(Integer connectionNumber) {
		this.connectionNumber = connectionNumber;
	}

}
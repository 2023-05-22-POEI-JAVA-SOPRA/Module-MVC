package fr.tpwebshopmvc.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_Users")
public class User {

	@Id
//	@NotNull(message = "Id ne doit pas être null")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
 @Column(name = "iduser")
	private Integer idUser;

	@Size(max = 20)
	@NotNull
	@Email
	private String login;
	@NotNull
	@Size(max = 20)
	private String password;
	@NotNull
	@PositiveOrZero
	@Column(name = "connectionnumber")
	private Integer connectionNumber;

//	@ManyToMany
//	@JoinTable(name = "T_Users_Roles_Associations", joinColumns = @JoinColumn(name = "idUser"), inverseJoinColumns = @JoinColumn(name = "idRole"))
//	private List<Role> roles = new ArrayList<>();

//	public List<Role> getRoles() {
//		return roles;
//	}

	public User(@Size(max = 20) @NotNull String login, @NotNull @Size(max = 20) String password,
			@NotNull @PositiveOrZero Integer connectionNumber) {
		super();

		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;

	}

//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	public User() {
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getConnectionNumber() {
		return connectionNumber;
	}

	public void setConnectionNumber(Integer connectionNumber) {
		this.connectionNumber = connectionNumber;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", password=" + password + ", connectionNumber="
				+ connectionNumber + "]";
	}
	
}

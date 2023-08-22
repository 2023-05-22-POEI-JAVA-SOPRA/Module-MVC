package fr.maboite.webshopspringboot.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity @Table(name = "users")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer id;
	private String login;
	private String password;
	@Column(name = "connection_number")
	private Integer connectionNumber;

	
	public User() {
		super();
	}
	
	public User(String login, String password, Integer connectionNumber) {
		super();
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
	}

	public User(Integer id, String login, String password, Integer connectionNumber) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
	}

	public Integer getId() {
		return id;
	}


	public String getLogin() {
		return login;
	}


	public String getPassword() {
		return password;
	}


	public Integer getConnectionNumber() {
		return connectionNumber;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setConnectionNumber(int connectionNumber) {
		this.connectionNumber = connectionNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", connectionNumber="
				+ connectionNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return connectionNumber == other.connectionNumber && Objects.equals(id, other.id)
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password);
	}  
}

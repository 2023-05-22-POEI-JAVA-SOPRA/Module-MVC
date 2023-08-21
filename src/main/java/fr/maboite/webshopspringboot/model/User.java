package fr.maboite.webshopspringboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity @Table(name = "users")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String login;
	private String password;
	@Column(name = "connection_number")
	private int connectionNumber;

	
	public User() {
		super();
	}
	
	public User(String login, String password, int connectionNumber) {
		super();
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


	public int getConnectionNumber() {
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
}

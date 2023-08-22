package fr.maboite.webshopspringboot.dto;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.webshopspringboot.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {
	private Integer id;
	@NotEmpty @Size(max = 20) @Email
	private String login;
	@NotEmpty @Size(max = 20)
	private String password;	
	@NotNull
	private Integer connectionNumber;
	
	public UserDTO(Integer id, String login, String password, Integer connectionNumber) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
	}
	
	public UserDTO(User user) {
		super();
		id = user.getId();
		login = user.getLogin();
		password = user.getPassword();
		connectionNumber = user.getConnectionNumber();
	}

	public UserDTO() {
		super();
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

	public void setId(Integer id) {
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
		return "UserDTO [id=" + id + ", login=" + login + ", password=" + password + ", connectionNumber="
				+ connectionNumber + "]";
	}

	public User convertToUser() {
		return new User(id, login, password, connectionNumber);
	}
	
	public static List<UserDTO> convertListToDTO(List<User> users) {
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (User u : users) {
			usersDTO.add(new UserDTO(u));
		}
		return usersDTO;
	}
}

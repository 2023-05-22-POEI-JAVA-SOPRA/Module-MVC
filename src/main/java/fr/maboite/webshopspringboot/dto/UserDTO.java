package fr.maboite.webshopspringboot.dto;

public class UserDTO {
	private Integer id;
	private String login;
	private String password;	
	private int connectionNumber;
	
	public UserDTO(Integer id, String login, String password, int connectionNumber) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
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

	public int getConnectionNumber() {
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
}

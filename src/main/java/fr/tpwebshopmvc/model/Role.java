package fr.tpwebshopmvc.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_Roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrole")
	private Integer id;
	@Column(name = "rolename")
	@Size(max = 20)
	@NotEmpty(message = "Role name can't be null or empty")
	private String roleName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Role() {
	}

	@Override
	public String toString() {
		return "[" + this.roleName + "]";
	}

	public Role(String roleName, List<User> users) {
		super();
		this.roleName = roleName;
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}

}
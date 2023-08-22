package fr.maboite.webshopspringboot.dto;

import fr.maboite.webshopspringboot.model.Role;
import jakarta.validation.constraints.Size;

public class RoleDto {
	private Integer idRole;

	
    @Size(max = 20, message = "Le name_role ne peut pas dépasser 20 caractères")
	private String name;
	
	public RoleDto() {
	}
	
	public RoleDto(Role role) {
		this.idRole = role.getIdRole();
		this.name = role.getName();
	}
	
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
	public Role toRole() {
		Role role = new Role();
		role.setIdRole(this.idRole);
		role.setName(this.name);
		return role;
	}
}

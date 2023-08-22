package fr.tp.shopifinal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_commands")
public class Command {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_command")
	private Integer idCommand;
	
	@Column(name = "command_date")
	private LocalDateTime commandDate;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	public Integer getIdCommand() {
		return idCommand;
	}
	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}
	public LocalDateTime getCommandDate() {
		return commandDate;
	}
	public void setCommandDate(LocalDateTime commandDate) {
		this.commandDate = commandDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}

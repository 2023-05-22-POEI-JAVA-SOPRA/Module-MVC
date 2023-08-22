package fr.maboite.webshop.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table
public class Command {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id_command")
	private Long idCommand;
	
	@Column(name = "command_date")
	private LocalDate commandDate;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	
	public Long getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(Long idCommand) {
		this.idCommand = idCommand;
	}

	public LocalDate getCommandDate() {
		return commandDate;
	}

	public void setCommandDate(LocalDate commandDate) {
		this.commandDate = commandDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Command() {
		super();
	}


	public Command(LocalDate commandDate) {
		super();
		this.commandDate = commandDate;
	}



	public Command(Long idCommand, LocalDate commandDate) {
		super();
		this.idCommand = idCommand;
		this.commandDate = commandDate;
	}



	@Override
	public String toString() {
		return "Command [idCommand=" + idCommand + ", commandDate=" + commandDate +"]";
	}
	
	
	
}

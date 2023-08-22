package fr.maboite.webshop.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.maboite.webshop.model.Command;

@Repository
public interface CommandDao extends CrudRepository<Command, Long> {

	//List<Command> findByUserLogin(String login);
	
}

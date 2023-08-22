package fr.maboite.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.maboite.webshop.dao.CommandDao;
import fr.maboite.webshop.model.Command;

@Component
public class CommandService {

	@Autowired
	private CommandDao commandDao;
	
	public Iterable<Command> getAll(){
		return this.commandDao.findAll();
	}
	
	public Command getById(Long id) {
		return this.commandDao.findById(id).get();
	}
	
	public Command save(Command command) {
		return this.commandDao.save(command);
	}
	
	public void delete(Long id) {
		this.commandDao.deleteById(id);
	}

}

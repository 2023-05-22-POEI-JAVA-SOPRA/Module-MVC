package fr.tp.shopi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.tp.shopi.entity.Command;

@Service
public class CommandService {
	
	private CommandDao commandDao;

	public CommandService(CommandDao commandDao) {
		this.commandDao = commandDao;
	}

	public CommandDao getCommandDao() {
		return commandDao;
	}

	public void setCommandDao(CommandDao commandDao) {
		this.commandDao = commandDao;
	}

	public void save(Command entity) {
		 commandDao.save(entity);
	}

	public Optional<Command> findById(Long id) {
		return commandDao.findById(id);
	}

	public Iterable<Command> findAll() {
		return commandDao.findAll();
	}

	public void deleteById(Long id) {
		commandDao.deleteById(id);
	}

	public void delete(Command entity) {
		commandDao.delete(entity);
	}
	
	public List<Command> findByUserId(Integer id) {
		return commandDao.findByUserIdUser(id);
	}
	

}

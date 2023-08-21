package fr.tp.shopi.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.tp.shopi.entity.Command;

@Repository
public interface CommandDao extends CrudRepository<Command, Long> {
	
	List<Command> findByUserIdUser(Integer id);
	
}

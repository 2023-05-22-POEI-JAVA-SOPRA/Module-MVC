package fr.maboite.webshopspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.maboite.webshopspringboot.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer>{

}

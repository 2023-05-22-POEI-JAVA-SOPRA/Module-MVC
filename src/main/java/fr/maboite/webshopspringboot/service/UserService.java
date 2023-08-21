package fr.maboite.webshopspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maboite.webshopspringboot.model.User;
import fr.maboite.webshopspringboot.repository.UserDAO;

@Service
public class UserService {
	@Autowired
	UserDAO ud;
	
	public Iterable<User> getAll() {
		return ud.findAll();
	}
}

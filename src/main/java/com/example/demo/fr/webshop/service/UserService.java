package com.example.demo.fr.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.fr.webshop.dao.UserDAO;
import com.example.demo.fr.webshop.model.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	
	
	
	
	
	public User save(User user) {
		return userDAO.save(user);
	}
	
	public User getById(Long id) {
		return userDAO.findById(id).orElse(null);
	}
	
	public Iterable<User> getAll() {
		return userDAO.findAll();
	}
	
	public void delete(Long id) {
		userDAO.deleteById(id);
	}
	
	
	
	public List<User> findByLoginAndPassword(String login, String password){
		return userDAO.findByLoginAndPassword(login, password);
	}
	public List<User> findByLogin(String login){
		return userDAO.findByLogin(login);
	}

	public List<User> getByPartialLogin(String partialLogin){
		return userDAO.getByLoginLike(partialLogin);
	}
	
	
	
	
}
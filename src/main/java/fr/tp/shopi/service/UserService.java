package fr.tp.shopi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tp.shopi.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserService(UserDao userDao) {
		
		this.userDao = userDao;
	}

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public void save(User entity) {
		userDao.save(entity);
	}

	public Optional<User> findById(Long id) {
		return userDao.findById(id);
	}

	public Iterable<User> findAll() {
		return userDao.findAll();
	}

	public void deleteById(Long id) {
		userDao.deleteById(id);
	}

	public void delete(User entity) {
		userDao.delete(entity);
	}
	
	public List<User> findByPassword(String password){
		return this.userDao.findByPassword(password);
	}
	
	public List<User> findByLogin(String login){
		return this.userDao.findByLogin(login);
	}
	
	public List<User> findByLoginAndPassword(String login, String password){
		return this.userDao.findByLoginAndPassword(login, password);
	}
	
	
	
	
}

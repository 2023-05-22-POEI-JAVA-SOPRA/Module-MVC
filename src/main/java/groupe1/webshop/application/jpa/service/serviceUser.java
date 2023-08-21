package groupe1.webshop.application.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe1.webshop.application.jpa.dao.UserDao;
import groupe1.webshop.application.jpa.entity.User;

@Service
public class serviceUser {
	
	@Autowired
	private UserDao monUserDao;
	
	public List<User> getAll(){
		return (List<User>) this.monUserDao.findAll();
	}
	
	public Optional<User> getById(Integer id) {
		return this.monUserDao.findById(id);
	}
	
	public User save(User user) {
		return this.monUserDao.save(user);
	}
	
	public void deleteById(Integer id) {
		this.monUserDao.deleteById(id);
	}
	
	public List<User> getByLoginAndPassword(String login, String password){
		return this.monUserDao.findByLoginAndPassword(login, password);
	}
}

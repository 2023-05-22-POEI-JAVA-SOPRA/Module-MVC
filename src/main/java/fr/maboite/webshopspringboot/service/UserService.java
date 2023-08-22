package fr.maboite.webshopspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maboite.webshopspringboot.model.User;
import fr.maboite.webshopspringboot.repository.UserDAO;

@Service
public class UserService {
	@Autowired
	UserDAO ud;
	
	public Iterable<User> getAllOrderByIdAsc() {
		return ud.findAllByOrderByIdAsc();
	}
	
	public User getById(Integer id) {
		return ud.findById(id).get();
	}
	
	public User save(User user) {
		return ud.save(user);
	}
	
	public User deleteById(Integer id) {
		User u = getById(id);
		ud.deleteById(id);
		return u;
	}
	
	public List<User> getByLoginLikeIgnoreCaseOrderByIdAsc(String search) {
		return ud.findByLoginContainingIgnoreCaseOrderByIdAsc(search);
	}

	public User update(User user) {
		User u =getById(user.getId());
		
		if(u == null)
			return null;
		
		u.setLogin(user.getLogin());
		u.setPassword(user.getPassword());
		u.setConnectionNumber(user.getConnectionNumber());
	
		return 	save(u);
	}
}

package fr.tpwebshopmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tpwebshopmvc.model.User;
import fr.tpwebshopmvc.repository.UserRepository;

@Service
public class UserService {
<<<<<<< HEAD
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAll()
	{
		return userRepository.findAll();
	}

=======
>>>>>>> d3142236f5fb2e145ec5f0834923c72f7ae0dc92
}

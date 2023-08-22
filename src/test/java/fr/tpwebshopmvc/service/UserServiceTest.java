package fr.tpwebshopmvc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.tpwebshopmvc.model.User;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	
	
	@Test
	public void test()
	{
//		Iterable<User> users = userService.getAll();
		
		User userInDb = userService.getById(1);
		Assertions.assertTrue(userInDb.getIdUser() != null, "User in db not found");
		userService.deleteById(1);
		User userDeleted = userService.getById(1);
		Assertions.assertNull(userDeleted );

	}

}

package fr.tpwebshopmvc.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.tpwebshopmvc.model.User;


@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@ParameterizedTest
	@CsvSource(value = { "3,4,5" }, delimiter = ',')
	public void getUserById(Integer id)
	{	
		User userInDb = userService.getById(id);
		Assertions.assertTrue(userInDb.getIdUser() != null, "User in db not found");
		userService.deleteById(1);
		User userDeleted = userService.getById(1);
		Assertions.assertNull(userDeleted,"userDeleted not null but should be" );
	}
	@Test
	public void getAll()
	{	
		List<User> users = userService.getAll();
		Assertions.assertTrue(users.size() > 0, "No users in db");
	}
	@ParameterizedTest
	@CsvSource(value = { "der,ip,nd" }, delimiter = ',')
	public void getByLoginLike(String loginLike)
	{	
		List<User> users = userService.getByLoginLike(loginLike);
		Assertions.assertTrue(users.size() > 0, "No users in db with loginLike value to " + loginLike);
	}
	@Test
	public void deleteUSer()
	{	
		User userInDb = userService.getById(1);
		Assertions.assertTrue(userInDb.getIdUser() != null, "User in db not found");
		userService.deleteById(1);
		User userDeleted = userService.getById(1);
		Assertions.assertNull(userDeleted,"userDeleted not null but should be" );
	}
	
	@Test
	public void updtateUSer()
	{	
		User userInDb = userService.getById(2);
		Assertions.assertTrue(userInDb.getIdUser() != null, "User in db not found");
		User user = new User();
		user.setIdUser(userInDb.getIdUser());
		user.setConnectionNumber(userInDb.getConnectionNumber()+10);
		user.setLogin(userInDb.getLogin());
		user.setPassword(userInDb.getPassword());
		userService.updateUser(user);
		User userInDbAfter = userService.getById(2);
		Assertions.assertTrue(userInDbAfter.getConnectionNumber() ==  user.getConnectionNumber(),"userInDbAfter not updated" );
	}
	
	@Test
	public void saveUSer()
	{	
		User user = new User("max@gmail.com","password",20);
		user.setIdUser(6);
		userService.saveUser(user);
		List<User> usersInDb= userService.getByLoginLike("max@gmail.com");
		Assertions.assertTrue(usersInDb.size()>0,  "no users with login like max@gmail.com" );
		for (User us : usersInDb) {
			
			Assertions.assertNotNull(us, "usersInDb null" );
		}
		User userSaved = userService.getById(6);
		Assertions.assertTrue(userSaved.getLogin()=="max@gmail.com");
		Assertions.assertTrue(userSaved.getConnectionNumber()==20);
		Assertions.assertTrue(userSaved.getPassword()=="password");
	}

}

package fr.maboite.webshopspringboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.maboite.webshopspringboot.model.User;

@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService us;
	
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getbyid_user_with_non_existing_id() {
		assertNull(us.getById(1000000000));
	}
	
	@Test
	public void getById_user_with_existing_id() {
		User uTest = new User(2, "paul@paul.com", "motdepasse", 655615546);
		assertEquals(uTest, us.getById(2));
	}
	
	//Create================================================================================================//
	
	@Test
	public void create_user_with_null_connectionNumber() {
		User u = new User("aaa@bb.com", "123456", null);
		assertNull(us.save(u));
	}

	@Test
	public void create_user_with_login_size_sup_to_20() {
		User u = new User("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa@bb.com", "12345678", 5162651);
		assertNull(us.save(u));
	}
	
	
	@Test
	public void create_valid_user() {
		User u = new User("test@test.com", "testtest", 5162651);
		assertEquals(u, us.save(u));
	}
	
	//Update================================================================================================//
	
	@Test
	public void update_user_with_non_existing_id() {
		User u = new User(100000000, "aaa@bb.com", "123456", 5162651);
		assertNull( us.update(u));
	}
	
	@Test
	public void update_user_with_null_password() {
		User u = new User(33, "aaa@bb.com", null, 5162651);
		assertNull(us.update(u));
	}
	

	@Test
	public void update_user_with_password_size_sup_to_20() {
		User u = new User(33, "aaaaa@bb.com", "12345678888888888888888888888888888888888888888", 5162651);
		assertNull(us.update(u));
	}
	
	@Test
	public void update_valid_user() {
		User u = new User(33, "testupdate@test.com", "testupdate", 111111111);
		assertEquals(u, us.update(u));
	}

}

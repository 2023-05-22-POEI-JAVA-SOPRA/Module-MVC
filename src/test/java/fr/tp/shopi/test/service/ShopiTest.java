package fr.tp.shopi.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import fr.tp.shopi.entity.User;
import fr.tp.shopi.service.ArticleService;
import fr.tp.shopi.service.RoleService;
import fr.tp.shopi.service.UserService;


@SpringBootTest
public class ShopiTest {
	@Test
	void contextLoads() {
	}

	@Autowired
	private ArticleService articleService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	
	
	@Test
	public void test_find_user_by_password() {
		String password = "ndo";
		Iterable<User> listOfUsers = userService.findByPassword(password);
		assertEquals(4, listOfUsers.iterator().next().getIdUser());
	}
	
	@Test
	public void test_not_null_find_user_by_password() {
		String password = "ibery";
		assertNotNull(userService.findByPassword(password));
	}
	
	@Test
	public void test_find_user_by_login() {
		String login = "jo";
		assertEquals(4, userService.findByLogin(login).get(0).getIdUser());
	}
	
	@Test
	public void test_not_null_find_user_by_login() {
		String login = "al";
		assertNotNull(userService.findByLogin(login));
	}
	
	@Test
	public void test_find_user_by_login_password() {
		String login = "jo";
		String password ="ndo";
		assertEquals(4, userService.findByLoginAndPassword(login,password).get(0).getIdUser());
	}
	
	@Test
	public void test_not_null_find_user_by_login_password() {
		String login = "al";
		String password = "ibery";
		assertNotNull(userService.findByLoginAndPassword(login,password));
	}
	
	@Test
	public void test_find_role_by_part_ignorecase() {
		String part = "MAITRE";
		
		assertEquals(2, roleService.findByNameContainingIgnoreCase(part).get(0).getIdRole());
	}
	
	@Test
	public void test_not_null_find_role_by_part() {
		String part = "EkZ";
		
		assertNotNull(roleService.findByNameContainingIgnoreCase(part));
	}
	
	@Test
	public void test_not_null_find_by_description_part() {
		String part = "cret";
		
		assertNotNull(articleService.findByDescriptionContaining(part));
	}
	
	@Test
	public void test_find_by_description_part() {
		String part = "abi";
		
		assertEquals(5,articleService.findByDescriptionContaining(part).get(0).getIdArticle());
	}
	
	@Test
	public void test_not_null_find_by_brand_price_range() {
		String brand = "papirusse";
		float min = 4f;
		float max = 22f;
		assertNotNull(articleService.findByBrandIgnoreCaseAndUnitaryPriceBetween(brand,min,max));
	}
	
	@Test
	public void test_find_by_brand_price_range() {
		String brand = "fabuloufou";
		float min = 4f;
		float max = 22f;
		assertEquals(1,articleService.findByBrandIgnoreCaseAndUnitaryPriceBetween(brand,min,max).get(0).getIdArticle());
	}
	

}

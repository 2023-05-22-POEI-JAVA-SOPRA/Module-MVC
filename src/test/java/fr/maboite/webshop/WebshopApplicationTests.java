package fr.maboite.webshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.maboite.webshop.model.Article;
import fr.maboite.webshop.model.Role;
import fr.maboite.webshop.model.User;
import fr.maboite.webshop.service.ArticleService;
import fr.maboite.webshop.service.RoleService;
import fr.maboite.webshop.service.UserService;

@SpringBootTest
class WebshopApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	UserService userService = new UserService();
	
	@Autowired
	RoleService roleService = new RoleService();
	
	@Autowired
	ArticleService articleService = new ArticleService();
	
	@Test
	public void testUserServiceSave() {
		User user = new User("lo@lo.com","12345",001);
		user.setIdUser(1l);
		User result = userService.save(user);
		assertNotNull(result);
		assertEquals(user.toString(), result.toString());
	}
	
	@Test
	public void testUserServiceFindByLoginContainingIgnoreCase() {
		User user = new User("lo@lo.com","12345",001);
		user.setIdUser(1l);
		List<User> result = userService.findByLoginContainingIgnoreCase("LO");
		assertNotNull(result);
		assertEquals(user.toString(), result.get(0).toString());
	}
	
	@Test
	public void testRoleServiceSave() {
		Role role = new Role("user");
		role.setIdRole(1l);
		Role result = roleService.save(role);
		assertNotNull(result);
		assertEquals(role.toString(), result.toString());
	}
	
	@Test
	public void testRoleServiceFindByNameContainsIgnoreCase() {
		Role role = new Role("user");
		role.setIdRole(1l);
		List<Role> result = roleService.findByNameContainsIgnoreCase("US");
		assertNotNull(result);
		assertEquals(role.toString(), result.get(0).toString());
	}
	
	@Test
	public void testAricleServiceSave() {
		Article article = new Article("pull","H&M",14.99f);
		article.setIdArticle(9l);
		Article result = articleService.save(article);
		assertNotNull(result);
		assertEquals(article.toString(), result.toString());
	}
	
	@Test
	public void testArticleServiceFindByDescriptionContainsIgnoreCase() {
		Article article = new Article("pull","H&M",14.99f);
		article.setIdArticle(9l);
		List<Article> result = articleService.findByDescriptionContainsIgnoreCase("Ul");
		assertNotNull(result);
		assertEquals(article.toString(), result.get(0).toString());
	}

}

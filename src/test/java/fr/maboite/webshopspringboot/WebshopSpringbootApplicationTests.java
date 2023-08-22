package fr.maboite.webshopspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.maboite.webshopspringboot.model.Role;
import fr.maboite.webshopspringboot.service.RoleService;

@SpringBootTest
class WebshopSpringbootApplicationTests {

	@Autowired
    private RoleService roleService;
	
	@BeforeEach
	public void setup() {
	    List<Role> roles = roleService.getAllRoles();

	    for (Role role : roles) {
	        roleService.deleteRole(role.getIdRole());
	    }
	}
	
    @Test
    public void testGetAllRoles() {
        Role role1 = new Role();
        role1.setName("Role 1");
        Role role2 = new Role();
        role2.setName("Role 2");

        roleService.saveRole(role1);
        roleService.saveRole(role2);

        List<Role> roles = roleService.getAllRoles();

        assertEquals(2, roles.size());
        assertEquals("Role 1", roles.get(0).getName());
        assertEquals("Role 2", roles.get(1).getName());
    }
}

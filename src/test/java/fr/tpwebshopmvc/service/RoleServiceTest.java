package fr.tpwebshopmvc.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.tpwebshopmvc.model.Role;
@SpringBootTest
public class RoleServiceTest {

	@Autowired
	RoleService roleService;

	@ParameterizedTest
	@CsvSource(value = { "3,4" }, delimiter = ',')
	public void getRoleById(Integer id) {
		Role RoleInDb = roleService.findById(id);
		Assertions.assertTrue(RoleInDb.getId() != null, "Role in db not found");
		roleService.deleteById(1);
		Role RoleDeleted = roleService.findById(1);
		Assertions.assertNull(RoleDeleted, "RoleDeleted not null but should be");
	}

	@Test
	public void getAll() {
		List<Role> Roles = roleService.findAll();
		Assertions.assertTrue(Roles.size() > 0, "No Roles in db");
	}

	@ParameterizedTest
	@CsvSource(value = { "dm,st,ger" }, delimiter = ',')
	public void getByRoleNameLike(String roleName) {
		List<Role> Roles = roleService.getByRoleNameLike(roleName);
		Assertions.assertTrue(Roles.size() > 0, "No Roles in db with roleName value to " + roleName);
	}

	@Test
	public void deleteRole() {
		Role RoleInDb = roleService.findById(1);
		Assertions.assertTrue(RoleInDb.getId() != null, "Role in db not found");
		roleService.deleteById(1);
		Role RoleDeleted = roleService.findById(1);
		Assertions.assertNull(RoleDeleted, "RoleDeleted not null but should be");
	}

	@ParameterizedTest
	@CsvSource(value = { "SuperAdmin,CEO,CTO,HR" }, delimiter = ',')
	public void updtateRole(String roleName) {
		Role roleInDb = roleService.findById(2);
		Assertions.assertTrue(roleInDb.getId() != null, "Role in db not found");
		Role role = new Role();
		role.setId(role.getId());
		role.setRoleName(roleName);

		roleService.updateRole(role);
		Role roleInDbAfter = roleService.getByRoleName(roleName);
		Assertions.assertFalse(roleInDbAfter.getRoleName().equals(roleInDb.getRoleName()),
				"RoleInDbAfter not updated" + roleInDbAfter.getRoleName() +roleInDb.getRoleName());
	}

	@ParameterizedTest
	@CsvSource(value = { "SuperAdmine,CEO,CTO,HR" }, delimiter = ',')
	public void saveRole(String roleName) {
		Role Role = new Role(roleName);
		roleService.save(Role);
		List<Role> rolesInDb = roleService.getByRoleNameLike(roleName);
		Assertions.assertTrue(rolesInDb.size() > 0, "no Roles with rolename" + roleName);
		for (Role us : rolesInDb) {

			Assertions.assertNotNull(us, "RolesInDb null");
		}
		Role roleSave = roleService.getByRoleName(roleName);
		Assertions.assertTrue(roleSave.getRoleName().equals(roleName));

	}

}

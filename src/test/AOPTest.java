package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.Role;
import service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class AOPTest {

	@Autowired
	private RoleService roleService;
	
	@Test
	public void test() {
		Role role = new Role();
		role.setId(3);
		role.setName("test logger advice");
		// roleService.save(role);
	}
	
}

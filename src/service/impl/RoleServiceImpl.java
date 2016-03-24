package service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pojo.Role;
import service.RoleService;
import dao.RoleDAO;

@Service("roleService")
@Scope("prototype")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDAO roleDAO;

	@Transactional
	public Role get(Integer id) {
		Role role = new Role();
		role.setName("role");
		roleDAO.save(role);
		// throw new RuntimeException();// 抛出异常,事务回滚
		return roleDAO.get(id);
	}

}

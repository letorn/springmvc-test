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
		return roleDAO.get(id);
	}

}

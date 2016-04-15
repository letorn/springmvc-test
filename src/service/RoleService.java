package service;

import pojo.Role;

public interface RoleService {

	public Role get(Integer id);

	public boolean save(Role role);
	
}

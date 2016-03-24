package dao;

import java.util.List;

import pojo.Role;

public interface RoleDAO {

	public Role get(Integer id);

	public List<Role> find(Integer start, Integer limit);

	public Integer countAll();
	
	public boolean save(Role role);

}

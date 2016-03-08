package dao;

import java.util.List;

import pojo.User;

public interface UserDAO {

	public User get(Integer id);

	public List<User> find(Integer start, Integer limit);

	public Integer countAll();

}

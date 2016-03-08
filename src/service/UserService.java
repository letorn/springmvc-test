package service;

import pojo.Pager;
import pojo.User;

public interface UserService {

	public Pager<User> page(Integer start, Integer limit);

}

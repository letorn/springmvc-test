package service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pojo.Pager;
import pojo.User;
import service.UserService;
import dao.UserDAO;

@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDAO;

	@Override
	public Pager<User> page(Integer start, Integer limit) {
		return new Pager<User>(userDAO.countAll(), userDAO.find(start, limit));
	}

}

package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pojo.User;
import dao.UserDAO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public User get(Integer id) {
		return jdbcTemplate.queryForObject("select * from user where id=?", new Object[] { id }, User.getRowMapper());
	}

	public List<User> find(Integer start, Integer limit) {
		return jdbcTemplate.query("select * from user limit ?,?", new Object[] { start, limit }, User.getRowMapper());
	}

	public Integer countAll() {
		return jdbcTemplate.queryForObject("select count(id) from user", Integer.class);
	}

}

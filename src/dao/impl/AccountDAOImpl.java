package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pojo.Account;
import dao.AccountDAO;
import dao.mapper.AccountMapper;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {

	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private AccountMapper accountMapper;

	public Account getAccountByName(String accountName) {
		return accountMapper.getAccountByName(accountName);
	}

	public List<Account> find(Integer start, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer countAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

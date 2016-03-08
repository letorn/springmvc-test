package dao;

import java.util.List;

import pojo.Account;

public interface AccountDAO {

	public Account getAccountByName(String accountName);

	public List<Account> find(Integer start, Integer limit);

	public Integer countAll();

}

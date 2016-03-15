package service;

import pojo.Account;

public interface AccountService {

	public Account getByName(String name);

	public void updateAccount(Account account);

	public void reload();

}

package service;

import pojo.Account;

public interface AccountService {

	public Account getAccountByName(String accountName);

	public void updateAccount(Account account);

	public void reload();

}

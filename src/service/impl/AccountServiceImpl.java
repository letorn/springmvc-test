package service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pojo.Account;
import service.AccountService;
import dao.AccountDAO;

@Service("accountService")
@Scope("prototype")
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDAO accountDAO;

	@Cacheable(value = "accountCache")
	public Account getByName(String accountName) {
		return accountDAO.getByName(accountName);
	}

	@CacheEvict(value = "accountCache", key = "#account.getName()")
	public void updateAccount(Account account) {

	}

	@CacheEvict(value = "accountCache", allEntries = true)
	public void reload() {

	}

}

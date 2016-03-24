package dao.mapper;

import pojo.Account;

public interface AccountMapper {

	public Account get(Integer id);
	public Account getByName(String name);

}

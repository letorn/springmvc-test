package pojo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Date birth;
	private Integer roleId;

	private List<Account> accounts;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	private static RowMapper<User> rowMapper = new RowMapper<User>() {
		public User mapRow(ResultSet resultSet, int index) throws SQLException {
			User user = new User();
			user.setId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setBirth(resultSet.getDate("birth"));
			user.setRoleId(resultSet.getInt("role_id"));
			return user;
		}
	};

	public static RowMapper<User> getRowMapper() {
		return rowMapper;
	}

}

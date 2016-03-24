package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.Account;
import pojo.User;
import dao.mapper.AccountMapper;
import dao.mapper.UserMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class MyBatisTest {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test() {
		Account account = accountMapper.getByName("admin");
		System.out.println("account: " + account.getName());
	}
	
	@Test
	public void testSomeToOne() {
		Account account = accountMapper.get(1);
		System.out.println("account: " + account.getName() + ", user: " + account.getUser().getName());
	}
	
	@Test
	public void testOneToSome() {
		User user = userMapper.get(1);
		System.out.println("user: " + user.getName() + ", accountCount: " + user.getAccounts().size());
	}
	
	@Test
	public void testFirstLevelCache() {
		Account account = accountMapper.getByName("admin");
		Account account2 = accountMapper.getByName("admin");
		System.out.println("account: " + account.getName());
		System.out.println("account2: " + account2.getName());
	}
	
	@Test
	public void testSecondLevelCache() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Account account = sqlSession.getMapper(AccountMapper.class).getByName("admin");
		
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		Account account2 = sqlSession2.getMapper(AccountMapper.class).getByName("admin");
		
		System.out.println("account: " + account.getName());
		System.out.println("account2: " + account2.getName());
	}
	
}

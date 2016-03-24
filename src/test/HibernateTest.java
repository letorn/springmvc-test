package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pojo.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class HibernateTest {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void test() {
		Session session = sessionFactory.openSession();
		Role role = (Role) session.get(Role.class, 1);
		System.out.println("role: " + role);
	}

	@Test
	public void testPersistence() {
		Session session = sessionFactory.openSession();
		Role role = new Role();// 游离状态
		role.setName("test");
		session.save(role);// 持久状态
		role.setName("persistence");
		session.flush();
	}

	@Test
	@Transactional
	public void testTransaction() {
		Session session = sessionFactory.getCurrentSession();
		Role role = new Role();
		role.setName("transaction");
		session.save(role);
	}

	@Test
	public void testFirstLevelCache() {
		Session session = sessionFactory.openSession();
		Role role = (Role) session.get(Role.class, 1);
		Role role2 = (Role) session.get(Role.class, 1);// 一级缓存,session级别
		System.out.println("role: " + role);
		System.out.println("role2: " + role2);
	}

	@Test
	public void testSecondLevelCache() {
		Session session = sessionFactory.openSession();
		Role role = (Role) session.get(Role.class, 1);

		Session session2 = sessionFactory.openSession();
		Role role2 = (Role) session2.get(Role.class, 1);

		System.out.println("role: " + role);
		System.out.println("role2: " + role2);
	}

	@Test
	public void testQueryCache() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Role where name = 'admin'");
		query.setCacheable(true);
		// Role role = (Role) query.uniqueResult();
		Role role = (Role) query.list().get(0);

		Session session2 = sessionFactory.openSession();
		Query query2 = session2.createQuery("from Role where name = 'admin'");
		query2.setCacheable(true);// 查询缓存
		// Role role2 = (Role) query2.uniqueResult();
		Role role2 = (Role) query2.list().get(0);

		Session session3 = sessionFactory.openSession();
		Role role3 = (Role) session3.get(Role.class, 1);

		System.out.println("role: " + role);
		System.out.println("role2: " + role2);
		System.out.println("role3: " + role3);
	}

}

package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pojo.Role;
import dao.RoleDAO;

@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO {

	@Resource
	private SessionFactory sessionFactory;

	public Role get(Integer id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}

	public List<Role> find(Integer start, Integer limit) {
		Query query = sessionFactory.getCurrentSession().createQuery("select * from Role");
		query.setFirstResult(start);
		query.setMaxResults(limit);
		return query.list();
	}

	public Integer countAll() {
		return ((Long) sessionFactory.getCurrentSession().createQuery("select count(1) from Role").uniqueResult()).intValue();
	}

}

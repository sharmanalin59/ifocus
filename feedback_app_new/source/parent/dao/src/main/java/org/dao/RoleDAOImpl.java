package org.dao;

import java.util.List;

import org.domain.Role;
import org.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class RoleDAOImpl extends AbstractJpaDAO<Role> implements RoleDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	private  Session session;
	
	public RoleDAOImpl(){
		setClazz(Role.class);
	}
	public List<Role> getRoles() {
		return findAll();
	}

	public Role getRole(int roleId) {
		return findOne(roleId);
	}
	
	public List<Role> getRoles(List<Integer> roleIds) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from Role u where u.roleId in :roleIds");
		q.setParameterList("roleIds", roleIds);
		@SuppressWarnings("unchecked")
		List<Role> result = q.list();
		System.out.println("result size..."+result.size());
		if(result.size() >0)
		return result;
		return null;
	}

}

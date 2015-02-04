package org.dao;
/**
 * @author : nalin sharma
 *
 */
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends AbstractJpaDAO<User> implements UserDAO {
	
	public UserDAOImpl(){
		setClazz(User.class );
	}

	@Autowired
	DataSource dataSource;
	
	@Autowired
	SessionFactory sessionFactory;
	
	private  Session session;
	
/*	public UserDAOImpl(){
		//System.out.println("DAO constructor....");
		//System.out.println("sessionFactory...."+sessionFactory);
		//System.out.println("dataSource...."+dataSource);
		session = sessionFactory.openSession();
	}*/
	public void createUser(User userEntity) {
			//System.out.println("nalin..."+sessionFactory);
		    //session.saveOrUpdate(userEntity);
			save(userEntity);
	}

	public List<User> getUsers(List<Integer> userIds) {
		userIds.add(-9999);//empty list will result in exception, -999 shall not be any userId as they start from 1
		session = sessionFactory.openSession();
		Query q = session.createQuery("from User u where u.userId in :user_ids");
		q.setParameterList("user_ids", userIds);
		@SuppressWarnings("unchecked")
		List<User> result = q.list();
		System.out.println("result size..."+result.size());
		if(result.size() >0)
		return result;
		return null;
	}
	
	public List<User> getUsers() {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from User u where u.isDeleted = 0");
		@SuppressWarnings("unchecked")
		List<User> result = q.list();
		System.out.println("result size..."+result.size());
		if(result != null && result.size() >0)
		return result;
		return null;
	}

	public User getUser(Integer userId) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from User u where u.userId = :userId");
		q.setParameter("userId", userId);
		@SuppressWarnings("unchecked")
		List<User> result = q.list();
		System.out.println("result size..."+result.size());
		if(result.size() >0)
		return result.get(0);
		return null;
	}

	public List<User> getUsers(Integer roleId) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from User u join fetch u.roles r where r.roleId = :roleId and u.isDeleted = 0");
		q.setParameter("roleId", roleId);
		@SuppressWarnings("unchecked")
		List<User> users = new ArrayList<User>();
		List<User> result = q.list();
		for (Object object : result) {
			users.add((User)object);
		}
		System.out.println("result size..."+result.size());
		if(result.size() >0)
		return users;
		return null;
	}

	public void updateUser(User userEntity) {
		update(userEntity);
	}

	public User getUser(String empId) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from User u where u.employeeId = :employeeId");
		q.setParameter("employeeId", empId);
		@SuppressWarnings("unchecked")
		List<User> result = q.list();
		System.out.println("result size..."+result.size());
		if(result.size() >0)
		return result.get(0);
		return null;
	}
	
	public User getUserBasedOnEmailId(String emailId) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from User u where u.emailAddress = :emailId");
		q.setParameter("emailId", emailId);
		@SuppressWarnings("unchecked")
		List<User> result = q.list();
		System.out.println("result size..."+result.size());
		if(result.size() >0)
		return result.get(0);
		return null;
	}
	
	public User getUser(String emailId, String password) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from User u where u.emailAddress = :emailId and password = :password");
		q.setParameter("emailId", emailId);
		q.setParameter("password", password);
		@SuppressWarnings("unchecked")
		List<User> result = q.list();
		System.out.println("result size..."+result.size());
		if(result.size() >0)
		return result.get(0);
		return null;
	}
	
}

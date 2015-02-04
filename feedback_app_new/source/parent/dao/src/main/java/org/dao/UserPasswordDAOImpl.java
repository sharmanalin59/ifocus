package org.dao;

import java.util.List;

import org.domain.UserPassword;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserPasswordDAOImpl extends AbstractJpaDAO<UserPassword> implements UserPasswordDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public UserPasswordDAOImpl(){
		setClazz(UserPassword.class);
	}
	
	public List<UserPassword> getUserPasswords() {
		return findAll();
	}

	public void saveUserPassword(UserPassword userPassword){
		save(userPassword);
	}
	//@Transactional
	public void updateUserPassword(UserPassword userPassword){
		update(userPassword);
	}
	
	public void updateIsActive(Integer userId){
		Session session = sessionFactory.openSession();
	    Query q = session.createQuery("UPDATE UserPassword up SET up.active = 0 WHERE up.user.userId in :userId");
	    q.setParameter("userId", userId);
	    q.executeUpdate();

	}
	
	public UserPassword getPasswordRequest(Integer userId,boolean isActive,String token){
		Session session = sessionFactory.openSession();
	    Query q = session.createQuery("from UserPassword up WHERE up.user.userId = :userId "
	    		+ "and up.active =1 and up.appendedString=:token");
	    q.setParameter("userId", userId);
	    q.setParameter("token", token);
	    List<UserPassword> list = q.list();
	    if(list != null && list.size()>0)
	    	return list.get(0);
	    return null;
	}
}

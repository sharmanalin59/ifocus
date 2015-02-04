package org.dao;

import java.util.List;

import org.domain.EmployeeManagerArchieve;
import org.domain.UserManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author nalin sharma
 *
 */
@Repository
public class EmployeeManagerArchieveDAOImpl extends AbstractJpaDAO<EmployeeManagerArchieve> 
implements EmployeeManagerArchieveDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session session;
	public void createEmployeeMAnagerArchieve(
			EmployeeManagerArchieve employeeManagerArchieve) {
		save(employeeManagerArchieve);
	}

	public void modifyEmployeeMAnagerArchieve(
			EmployeeManagerArchieve employeeManagerArchieve) {
		update(employeeManagerArchieve);
	}

	
	public List<EmployeeManagerArchieve> getAll(Integer userId,
			Integer managerId) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from EmployeeManagerArchieve u where u.userId.userId = :userId and u.managerId.userId = :managerId");
		q.setParameter("userId", userId);
		q.setParameter("managerId", managerId);
		@SuppressWarnings("unchecked")
		List<EmployeeManagerArchieve> result = q.list();
		System.out.println("result size..."+result.size());
		if(result.size() >0)
		return result;
		return null;
	}
	

}

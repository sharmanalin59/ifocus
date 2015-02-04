package org.dao;
/**
 * @author : nalin sharma
 *
 */
import java.util.List;

import org.domain.EmployeeGroup;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeGroupDAOImpl extends AbstractJpaDAO<EmployeeGroup> implements EmployeeGroupDAO{

	public EmployeeGroupDAOImpl(){
		setClazz(EmployeeGroup.class);
	}
	public void createGroup(EmployeeGroup employeeGroupEntity) {
		save(employeeGroupEntity);
	}

	public void updateGroup(EmployeeGroup employeeGroupEntity) {
		update(employeeGroupEntity);
	}

	public List<EmployeeGroup> getAllGroups() {
		return findAll();
	}
	
	public EmployeeGroup getGroup(Integer groupId) {
		return findOne(groupId);
	}

}

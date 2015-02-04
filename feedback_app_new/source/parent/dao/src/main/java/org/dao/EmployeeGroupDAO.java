package org.dao;
import java.util.List;


/**
 * @author : nalin sharma
 *
 */
import org.domain.EmployeeGroup;

public interface EmployeeGroupDAO {

	public void createGroup(EmployeeGroup employeeGroupEntity);
	public void updateGroup(EmployeeGroup employeeGroupEntity);
	public List<EmployeeGroup>  getAllGroups();
	public EmployeeGroup getGroup(Integer groupId);
	
}

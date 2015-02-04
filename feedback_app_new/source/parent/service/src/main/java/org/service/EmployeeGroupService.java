package org.service;
import java.util.List;

import org.domain.EmployeeGroup;
/**
 * @author : nalin sharma
 *
 */
import org.dtos.EmployeeGroupDTO;

public interface EmployeeGroupService {
	
	public void createGroup(EmployeeGroupDTO employeeGroupDTO);
	public void updateGroup(EmployeeGroupDTO employeeGroupDTO);
	public List<EmployeeGroupDTO> getAllGroups();
	
}

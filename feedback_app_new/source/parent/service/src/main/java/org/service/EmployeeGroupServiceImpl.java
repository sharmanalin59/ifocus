package org.service;
/**
 * @author : nalin sharma
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.dao.EmployeeGroupDAO;
import org.dao.UserDAO;
import org.domain.EmployeeGroup;
import org.domain.User;
import org.dozer.Mapper;
import org.dtos.EmployeeGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeGroupServiceImpl implements EmployeeGroupService{

	@Autowired
	EmployeeGroupDAO employeeGroupDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	Mapper mapper;
	public void createGroup(EmployeeGroupDTO employeeGroupDTO) {
		EmployeeGroup employeeGroupEntity = mapper.map(employeeGroupDTO, EmployeeGroup.class);
		//attach approver
		User approver = userDAO.getUser(employeeGroupDTO.getApproverId());
		employeeGroupEntity.setApprover(approver);
		employeeGroupDAO.createGroup(employeeGroupEntity);
	}

	public void updateGroup(EmployeeGroupDTO employeeGroupDTO) {
		EmployeeGroup employeeGroupEntity = mapper.map(employeeGroupDTO, EmployeeGroup.class);
		employeeGroupDAO.updateGroup(employeeGroupEntity);
	}

	public List<EmployeeGroupDTO> getAllGroups() {
		List<EmployeeGroup> employeeGroups = employeeGroupDAO.getAllGroups();
		List<EmployeeGroupDTO> employeeGroupDTOs = new ArrayList<EmployeeGroupDTO>(); 
		for (EmployeeGroup employeeGroup : employeeGroups) {
			EmployeeGroupDTO employeeGroupDTO = mapper.map(employeeGroup, EmployeeGroupDTO.class);
			employeeGroupDTOs.add(employeeGroupDTO);
		}
		return employeeGroupDTOs;
	}

}

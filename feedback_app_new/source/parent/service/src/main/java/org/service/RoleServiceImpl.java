package org.service;

import java.util.ArrayList;
import java.util.List;

import org.dao.RoleDAO;
import org.domain.Role;
import org.dozer.Mapper;
import org.dtos.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	Mapper mapper;
	
	@Transactional
	public List<RoleDTO> getAllRoles() {
		List<Role> roles = roleDAO.getRoles();
		List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
		if(roles != null){
			for (Role role : roles) {
				RoleDTO roleDTO = 
					      mapper.map(role, RoleDTO.class);
				roleDTOs.add(roleDTO);
			}
		}
		return roleDTOs;
	}

}

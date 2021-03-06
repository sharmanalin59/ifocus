package org.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dao.RoleDAO;
import org.dao.UserDAO;
import org.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service("customSpringSecurityService")
public class CustomSpringSecurityService implements UserDetailsService {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	
	public CustomSpringSecurityService(){
		System.out.println("CustomSpringSecurityService................");
	}
	
	public UserDetails loadUserByUsername(String emailId) 
               throws UsernameNotFoundException {
		System.out.println("-----------------------------loadUserByUsername");
		org.domain.User user = userDao.getUserBasedOnEmailId(emailId);
		List<Role> roles = user.getRoles();//new ArrayList<Role>();
		//Role role = roleDao.getRole(1);
		//roles.add(role);
		List<GrantedAuthority> authorities = buildUserAuthority(roles);
 
		return buildUserForAuthentication(user, authorities);
		
	}
 
	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(org.domain.User user, 
		List<GrantedAuthority> authorities) {
/*		  String passwordEntered = user.getPassword();
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(passwordEntered);
		    System.out.println("HELLOZ  ---->  " + encodedPassword);*/
		return new User(user.getEmailAddress(), 
				user.getPassword(), true, 
                        true, true, true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (Role role : roles) {
			setAuths.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
 
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
 
		return Result;
	}

}

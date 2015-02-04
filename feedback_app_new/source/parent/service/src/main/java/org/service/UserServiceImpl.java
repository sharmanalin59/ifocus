package org.service;
/**
 * @author : nalin sharma
 *
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.dao.EmployeeManagerArchieveDAO;
import org.dao.RoleDAO;
import org.dao.UserDAO;
import org.dao.UserManagerDAO;
import org.domain.EmployeeGroup;
import org.domain.EmployeeManagerArchieve;
import org.domain.Role;
import org.domain.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(value="txName")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO dao;
		
	@Autowired
	Mapper mapper;
	
	@Autowired
	UserManagerDAO userManagerDAO;
	
	@Autowired
	EmployeeManagerArchieveDAO employeeManagerArchieveDAO;
	
	@Autowired
	RoleDAO roleDAO;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Transactional//(value="txName2",isolation=Isolation.REPEATABLE_READ)
	public String createUser(UserDTO userDTO) {

		User userEntity = convertUserToUserDTO(userDTO);
		userEntity.setUserId(null);
		
		//created by shall be picked up from session
		userEntity.setCreationDate(new Date());
		Date joiningDate = userEntity.getJoiningDate();
		Integer appFre = userEntity.getAppraisalFrequency();
		Integer feedFre = userEntity.getFeedBackFrequency();
		if(joiningDate != null && appFre != null && appFre>0 && feedFre != null && feedFre>0){

			userEntity.setNextAppraisalDate(DateUtils.addMonths(joiningDate, appFre));
			userEntity.setNextFeedbackDate(DateUtils.addMonths(joiningDate, feedFre));
			
		}
		System.out.println("userEntity..."+userEntity);
		dao.createUser(userEntity);
		return userEntity.getEmployeeId();
	}	
	
	@Transactional
	public void saveArchieveEntries(String employeeId){
//		dao.createUser(user);
		User userEntity = dao.getUser(employeeId);
		//System.out.println(dao.getUserBasedOnEmailId("a"));
		List<User> managers = userEntity.getManagers();
		List<Integer> managerIds = new ArrayList<Integer>();
		if(managerIds != null){
			for (User manager : managers) {
				Integer managerId = manager.getUserId();
/*				UserManager userManager = new UserManager();
				UserManagerId userManagerId = new UserManagerId();
				userManagerId.setManagerId(managerId);
				userManagerId.setUserId(userEntity.getUserId());
				userManager.setUserManagerId(userManagerId);
				userManagerDAO.createUserManager(userManager);*/
				managerIds.add(managerId);
			}
			fillArchieveTable(userEntity, managerIds);
	
		}
	}
	private List<Role> getRoles(List<Integer> roles){
		if(roles!= null && roles.size()>0){
			return roleDAO.getRoles(roles);
		}
		return null;
	}
	
	private User convertUserToUserDTO(UserDTO userDTO){
		System.out.println("UserServiceImpl......"+dao);
		 mapper = new DozerBeanMapper(); 
		 System.out.println("userDTO....."+userDTO);
		User userEntity = 
			      mapper.map(userDTO, User.class);
		//attach the nested objects
		userEntity.setRoles(getRoles(userDTO.getRoleIds()));
		
		List<Integer> manIds = userDTO.getManagerIds();
		List<User> managers = dao.getUsers(manIds);
		userEntity.setManagers(managers);
		//attach approver..
		User approver = dao.getUser(userDTO.getApproverId());
		userEntity.setApprover(approver);
		return userEntity;
	}
	
	
	private UserDTO convertUserDTOToUser(User userEntity){
		System.out.println("inside convertUserDTOToUser....");
		 mapper = new DozerBeanMapper(); 
		 UserDTO userDTO = 
			      mapper.map(userEntity, UserDTO.class);
		
		System.out.println("userEntity.."+userEntity);
		//UserDTO userDTO = new UserDTO();
			      mapper.map(userEntity, UserDTO.class);
	    //attach approver 
		User approver = userEntity.getApprover();
		if(approver != null){
		    userDTO.setApproverId(approver.getUserId());
		    String name = approver.getFirstName();
		    userDTO.setApproverName(name);
		    userDTO.setApproverType(approver.getApproverType());
		}
		//attach emp group
	    EmployeeGroup empGroup = userEntity.getGroup();
	    if(empGroup != null){
	    userDTO.setGroupId(empGroup.getGroupId());
	    userDTO.setGroupName(empGroup.getGroupName());
	    }
	    //attach managers map and not list
	    List<User> managers = userEntity.getManagers();
	    //attach manager ids
	    List<Integer> managerIds = new ArrayList<Integer>();
	    for (User manager : managers) {
	    	managerIds.add(manager.getUserId());
		}
	    userDTO.setManagerIds(managerIds);
	    Map<Integer,String> managersMap = new HashMap<Integer,String>();
	    for (User manager : managers) {
	    	String name = manager.getFirstName() +" "+manager.getLastName();
			managersMap.put(manager.getUserId(), name);
		}
	    //attach role ids
	    List<Role> roles = userEntity.getRoles();
	    
	    userDTO.setManagersMap(managersMap);//(managersMap);// check
/*	    userDTO.setPassword(userEntity.getPassword());
	    userDTO.setPhoneNumber(userEntity.getPhoneNumber());
	    userDTO.setPhoto(userEntity.getPhoto());
	    userDTO.setSkillset(userEntity.getSkillset());*/
	    userDTO.setRoleIds(getRoleIds(userEntity.getRoles()));
	    System.out.println("userDTO...."+userDTO);
	    return userDTO;
	}
	private List<Integer> getRoleIds(List<Role> roles){
		List<Integer> roleIds = new ArrayList<Integer>();
		if(roles != null && roles.size() >0){
		    for (Role role : roles) {
		    	Integer roleId = role.getRoleId();
		    	roleIds.add(roleId);
			}
		    return roleIds;
		}  
		return null;
	}
	private int checkIfIdExistsInList(int findManagerId, List<Integer> managerIds){
		for (Integer managerId : managerIds) {
			if(findManagerId == managerId)
				return 0;
		}
		return 1;
	}
	@Transactional
	public void updateUser(UserDTO userDTO) {
		User userEntity = convertUserToUserDTO(userDTO);
		userEntity.setUserId(userDTO.getUserId());
		 List<Integer> managerIds = userDTO.getManagerIds();
		 List<Integer> newManagerIds = new ArrayList<Integer>();
		 List<Integer> allCurrentManagerIds = new ArrayList<Integer>();
		Integer userId = userDTO.getUserId();
		if(userId != null){
		//archieve the entries before deleting and then remove entries from usermanager
		User delManOfUser = dao.getUser(userId);
		List<User> oldManagers = delManOfUser.getManagers();
		List<User> managersToBeDeleted = new ArrayList<User>();
		List<Integer> managerIdsToBeDeleted = new ArrayList<Integer>();
		List<Integer> matchedManagers = new ArrayList<Integer>();
		if(oldManagers != null && oldManagers.size()>0){
			System.out.println("oldManagers.size()...."+oldManagers.size());
			 for (User oldManager : oldManagers) {
				 int flag = 0;
				 flag = checkIfIdExistsInList(oldManager.getUserId(), managerIds);
				 if(flag == 0){
					 matchedManagers.add(oldManager.getUserId());
				 }
				 if(flag == 1) {
					 managersToBeDeleted.add(oldManager);
					 managerIdsToBeDeleted.add(oldManager.getUserId());
/*				 EmployeeManagerArchieve employeeManagerArchieve = new EmployeeManagerArchieve();
				 employeeManagerArchieve.setUserId(delManOfUser);
				 employeeManagerArchieve.setManagerId(oldManager);
				// UserManager userManager = userManagerDAO.getUserManager(delManOfUser.getUserId(),oldManager.getUserId());
				 //employeeManagerArchieve.setStartDate(userManager.getAssignedDate());
				 employeeManagerArchieve.setEndDate(new Date());
				 //System.out.println("being deleted...."+employeeManagerArchieve);
				 employeeManagerArchieveDAO.createEmployeeMAnagerArchieve(employeeManagerArchieve);*/
				 }
			}
			 if(managersToBeDeleted != null && managersToBeDeleted.size()>0){
			userManagerDAO.removeUserManagerEntriesBasedOnManagerEntityList(userId, managersToBeDeleted);
			 }
		}
		newManagerIds = managerIds;
		allCurrentManagerIds = newManagerIds;
		newManagerIds.removeAll(matchedManagers);
		List<User> managers = null;
		List<User> associatedManagers = null;
		//add all entries in user manager
		 if(allCurrentManagerIds != null && allCurrentManagerIds.size()>0 && ((int)allCurrentManagerIds.get(0))>0){
			 associatedManagers = new ArrayList<User>();
			 for (Integer managerId : allCurrentManagerIds) {
				 User manager = dao.getUser(managerId);
				 associatedManagers.add(manager);
			}
			 
			 //associate new managers with the user
			 userEntity.setManagers(associatedManagers);
		 
		//for new entries
		 if(newManagerIds != null && newManagerIds.size()>0 && ((int)newManagerIds.get(0))>0)
		fillArchieveTable(userEntity, newManagerIds);
		 }
			System.out.println("userEntity..."+userEntity);
			userEntity.setRoles(getRoles(userDTO.getRoleIds()));
			dao.updateUser(userEntity);
			
			//update for old entries
		 if(managerIdsToBeDeleted != null && managerIdsToBeDeleted.size()>0 && ((int)managerIdsToBeDeleted.get(0))>0)
		    updateArchieveTable(userEntity, managerIdsToBeDeleted);
		}
	}
	private void fillArchieveTable(User userEntity,List<Integer> managerIds){
		for (Integer managerId : managerIds) {
			if((int)managerId >0){
			EmployeeManagerArchieve employeeManagerArchieve = new EmployeeManagerArchieve();
			employeeManagerArchieve.setStartDate(new Date());
			employeeManagerArchieve.setUserId(userEntity);
			employeeManagerArchieve.setManagerId(dao.getUser(managerId));
			employeeManagerArchieveDAO.createEmployeeMAnagerArchieve(employeeManagerArchieve);
			}
		}
	}
	
	
	
	private void updateArchieveTable(User userEntity,List<Integer> managerIds){
		for (Integer managerId : managerIds) {
			if((int)managerId >0){
			boolean toBeUpdated = false;
			EmployeeManagerArchieve tempEmployeeManagerArchieve = null;
			List<EmployeeManagerArchieve> employeeManagerArchieves = employeeManagerArchieveDAO.getAll(userEntity.getUserId(), managerId);
			if(employeeManagerArchieves == null)
				return;
			else{
				for (EmployeeManagerArchieve employeeManagerArchieve : employeeManagerArchieves) {
					if(employeeManagerArchieve.getEndDate() == null){
						toBeUpdated = true;
						tempEmployeeManagerArchieve = employeeManagerArchieve;
						break;
					}
				}
			}
			if(toBeUpdated){
				tempEmployeeManagerArchieve.setEndDate(new Date());
				employeeManagerArchieveDAO.modifyEmployeeMAnagerArchieve(tempEmployeeManagerArchieve);
			}

		}
		}
	}
	
	
	
	// not in use
	@Transactional
	public void updateUser1(UserDTO userDTO) {
		User userEntity = convertUserToUserDTO(userDTO);
		Integer userId = userDTO.getUserId();
		userEntity.setUserId(userId);
		 List<Integer> newManagerIds = userDTO.getManagerIds();
		 List<User> managers = null;

		 if(newManagerIds != null && newManagerIds.size()>0){
			managers = dao.getUsers(newManagerIds);
			}
			 //associate new managers with the user
			 userEntity.setManagers(managers);
		System.out.println("userEntity..."+userEntity);
		//add assigned_date
		dao.updateUser(userEntity);
		//userManagerDAO.updateAssignedDate(userId, newManagerIds);
		for (User manager : managers) {
			EmployeeManagerArchieve employeeManagerArchieve = new EmployeeManagerArchieve();
			employeeManagerArchieve.setStartDate(new Date());
			employeeManagerArchieve.setUserId(userEntity);
			employeeManagerArchieve.setManagerId(manager);
			employeeManagerArchieveDAO.createEmployeeMAnagerArchieve(employeeManagerArchieve);
		}

	}
	
	
	@Transactional
	public UserDTO getUser(Integer userId) {
	User userEntity = dao.getUser(userId);
    return convertUserDTOToUser(userEntity);
	}

	@Transactional
	public void removeUser(Integer userId) {
		User user = dao.getUser(userId);
		user.setIsDeleted(true);
		dao.updateUser(user);
		List<User> employees = user.getEmployees();
		System.out.println("manager's employees...");
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).getFirstName());
		}
		//remove all the entries from user manager table in which this guy was manager[he's no longer their manager]
		//archieve the usermanager archieve table with end date for the same
		
		//remove all the entries from user manager table in which this guy was present as user
		//archieve the usermanager archieve table with end date for the same
	}

	public User getUser(String emailId, String password) {
		User user = dao.getUser(emailId,password);
		return user;
	}

/*	public List<UsersBasicDetailsDTO> getUsers(Integer roleId) {
		List<UsersBasicDetailsDTO> basicDetailsDTOs = new ArrayList<UsersBasicDetailsDTO>();
		List<User> users = dao.getUsers(roleId);
		logger.debug("users size...."+users.size());
		System.out.println("users size...."+users.size());
		if(users != null && users.size()>0){
		for (User user : users) {
			UsersBasicDetailsDTO basicDetailsDTO = new UsersBasicDetailsDTO();
			basicDetailsDTO.setUserId(user.getUserId());
			basicDetailsDTO.setEmployeeId(user.getEmployeeId());
			basicDetailsDTO.setFirstName(user.getFirstName());
			basicDetailsDTO.setLastName(user.getLastName());
			basicDetailsDTOs.add(basicDetailsDTO);
		}
		return basicDetailsDTOs;
		}
		return null;
	}*/
	
/*	public static void main(String[] args) {
		UserServiceImpl impl = new UserServiceImpl();
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName("nalin");
		userDTO.setLastName("sharma");
		userDTO.setEmailAddress("a@a.a");
		RoleDTO dto = new RoleDTO();
		dto.setRoleId(1);
		userDTO.setRoleId(1);	
		//userDTO.setManagerIds();
		//userDTO.setUserId(1);
		impl.createUser(userDTO);
	}*/

	
}

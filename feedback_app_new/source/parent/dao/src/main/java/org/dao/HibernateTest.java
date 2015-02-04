package org.dao;
/**
 * @author : nalin sharma
 *
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.domain.Dept;
import org.domain.EmployeeGroup;
import org.domain.Role;
import org.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
public class HibernateTest {
 
	 private static SessionFactory factory; 
	 private static final String PERSISTENCE_UNIT_NAME = "psunit1";
     private static EntityManagerFactory factory1;


/*public static void main(String[] args) {
          //System.out.println("main...");
	
	SessionFactory sessFact = HibernateUtil.getSessionFactory();
    Session session = sessFact.getCurrentSession();
    org.hibernate.Transaction tr = session.beginTransaction();
    
    String strSql ="from Dept o";
    Query query = session.createQuery(strSql);
    List lst = query.list();
    for(Iterator it=lst.iterator();it.hasNext();){
    
            Dept emp=(Dept)it.next();
            System.out.println("Hello: ");
     }
      
    tr.commit();
    System.out.println("Data displayed");
    sessFact.close();
	
	
	
	createUser();
	//createGroup();
	System.out.println("hello-----");
	//dept();
	System.out.println("middle.....");
	HibernateUtil.shutdown();
    }
//@Transactional	
private static void dept() {System.out.println("hell0000o-----");
    Transaction tx;
    try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("helloooo-----");
		Dept dept = new Dept();
		tx = session.beginTransaction();
		dept.setName("ramu");
		session.save(dept);
		tx.commit();
		   session.close();
		    HibernateUtil.getSessionFactory().close();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("error---11----------");
	
	}
    System.out.println("hello-----");
}

@Transactional	
public static void createUser(){
	 Transaction tx;
	System.out.println("123...");
   // Session session = factory.openSession();
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    //tx = session.beginTransaction();

    User userEntity = new User();
    userEntity.setAppraisalFrequency(1);
    userEntity.setAppraisalFrequencyType((byte)1);
    
       User  approver = new User();
       approver.setUserId(2);
    userEntity.setApprover(approver);
    userEntity.setApproverType((byte) 1);
    userEntity.setCtc((float)100000.00);
    userEntity.setEmailAddress("asa@e2nd.dd");
    userEntity.setEmployeeId("323d");
    userEntity.setExperience(32);
    userEntity.setFeedBackFrequency(3);
    userEntity.setFeedBackFrequencyType((byte) 3);
    userEntity.setFirstName("nalin");
    userEntity.setGender("male");
         EmployeeGroup group = new EmployeeGroup();
         group.setGroupId(1);
    userEntity.setGroup(group);
    userEntity.setLastHikePercentage(20);
    userEntity.setLastName("sons");
         List<User> managers = new ArrayList<User>();
         User manager = new User();
         manager.setUserId(2);
         managers.add(manager);
    userEntity.setManagers(managers);
    userEntity.setPassword("dsdsv ds ");
    userEntity.setPhoneNumber(876544l);
    userEntity.setPhoto("dsdvvdsv");
         Role role = new Role();
         role.setRoleId(1);
    userEntity.setRole(role);
    userEntity.setSkillset("java");
    //userEntity.setUserId(27);
    System.out.println("000");
    session.saveOrUpdate(userEntity);
    //tx.commit();
    //HibernateUtil.shutdown();
    //session.close();
    //tx.commit();
	  // session.close();
	   // HibernateUtil.getSessionFactory().close();
    
   }



//@Transactional	
public static void createUser1(){
	 factory1 = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
     EntityManager em = factory1.createEntityManager();

     em.getTransaction().begin();

	
	
	 Transaction tx;
	System.out.println("nalin...");
 // Session session = factory.openSession();
  Session session = HibernateUtil.getSessionFactory().openSession();
  
  tx = session.beginTransaction();

  User userEntity = new User();
  userEntity.setAppraisalFrequency(1);
  userEntity.setAppraisalFrequencyType((byte)1);
  
     User  approver = new User();
     approver.setUserId(2);
  userEntity.setApprover(approver);
  userEntity.setApproverType((byte) 1);
  userEntity.setCtc((float)100000.00);
  userEntity.setEmailAddress("asa@e2nd.dd");
  userEntity.setEmployeeId("323d");
  userEntity.setExperience(32);
  userEntity.setFeedBackFrequency(3);
  userEntity.setFeedBackFrequencyType((byte) 3);
  userEntity.setFirstName("nalin");
  userEntity.setGender("male");
       EmployeeGroup group = new EmployeeGroup();
       group.setGroupId(1);
  userEntity.setGroup(group);
  userEntity.setLastHikePercentage(20);
  userEntity.setLastName("sons");
       List<User> managers = new ArrayList<User>();
       User manager = new User();
       manager.setUserId(2);
       managers.add(manager);
  userEntity.setManagers(managers);
  userEntity.setPassword("dsdsv ds ");
  userEntity.setPhoneNumber(876544l);
  userEntity.setPhoto("dsdvvdsv");
       Role role = new Role();
       role.setRoleId(1);
  userEntity.setRole(role);
  userEntity.setSkillset("java");
  userEntity.setUserId(1232);
  em.persist(userEntity);
  em.getTransaction().commit();
  em.close();
  
 }





public static void createGroup(){
    Transaction tx;
    try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("helloooo-----");
		EmployeeGroup group = new EmployeeGroup();
		tx = session.beginTransaction();
		group.setGroupName("group1");
		group.setGroupDescription("dd");
		session.save(group);
		tx.commit();
		   session.close();
		    HibernateUtil.getSessionFactory().close();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("error---11----------");
	
	}
    System.out.println("hello-----");
}
*/
}
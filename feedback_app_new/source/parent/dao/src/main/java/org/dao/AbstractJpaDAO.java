package org.dao;
/**
 * @author : nalin sharma
 *
 */
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDAO< T extends Serializable > {
	   
	   private Class< T > clazz;
	   
	   @PersistenceContext
	   EntityManager entityManager;
	   
	   public void setClazz( Class< T > clazzToSet ){
	      this.clazz = clazzToSet;
	   }
	   
	   public T findOne( Integer systemDefaultId ){
	      return this.entityManager.find( this.clazz, systemDefaultId );
	   }
	   public List< T > findAll(){
	      return this.entityManager.createQuery( "from " + this.clazz.getName() )
	       .getResultList();
	   }
	   
	   public void save( T entity ){
	      this.entityManager.persist( entity );
	   }
	   
	   public void update( T entity ){
	      this.entityManager.merge( entity );
	   }
	   
	   public void delete( T entity ){
	      this.entityManager.remove( entity );
	   }
	   public void deleteById( Integer entityId ){
	      T entity = this.findOne( entityId );
	      
	      this.delete( entity );
	   }
	}
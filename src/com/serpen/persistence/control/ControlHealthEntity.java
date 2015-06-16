package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.CareCenter;
import com.serpen.logic.entity.Catalog;
import com.serpen.logic.entity.HealthEntity;
import com.serpen.logic.entity.Service;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlHealthEntity {
	
	private Session session;
	public ControlHealthEntity(Session session) {
		this.session = session;
	}
	
	  public void insert(String nit, String name,String address,String phone,Catalog catalog){
	    	HealthEntity healthEntity = new HealthEntity();
	    	healthEntity.setNit(nit);
	    	healthEntity.setName(name);
	    	healthEntity.setAddress(address);
	    	healthEntity.setPhone(phone);
	    	healthEntity.setCatalog(catalog);
	    	session.save(healthEntity);
	    	session.beginTransaction().commit();
	    }
	  
	
	  public HealthEntity consult(String nit){	
	    	HealthEntity healthEntity =(HealthEntity) session.load(HealthEntity.class, nit) ; 
	        System.out.println(healthEntity);
	        return healthEntity;
	 }
	  public HealthEntity consultName(String name){
	    	Criteria criteria = session.createCriteria(HealthEntity.class);
	    	criteria.add(Restrictions.like("name",name));
	    	System.out.println((HealthEntity)criteria.list().get(0));
	    	return  (HealthEntity)criteria.list().get(0);
	    }
	  public List<HealthEntity> lisrHealthEntity(String name){
	    	Criteria criteria = session.createCriteria(HealthEntity.class);
	    	criteria.add(Restrictions.like("name","%"+name+"%"));
	    	 for (int i = 0; i < criteria.list().size(); i++) {
	   		  System.out.println(criteria.list().get(i));	
	   		}
	    	return  criteria.list();
	    }
	  
	  public List<HealthEntity> list(){
		  Criteria criteria = session.createCriteria(HealthEntity.class);
		  return criteria.list();
	  }
	  public void remove(String nit)throws ErrorConnection{
			HealthEntity healthEntity = (HealthEntity) session.load(HealthEntity.class, nit);
			session.delete(healthEntity);
			session.beginTransaction().commit();
		}
	  public void update(String nit,String name,String address,String phone)throws ErrorConnection{
			HealthEntity healthEntity= (HealthEntity) session.load(HealthEntity.class, nit);
			healthEntity.setName(name);
	    	healthEntity.setAddress(address);
	    	healthEntity.setPhone(phone);
			session.update(healthEntity);
			session.beginTransaction().commit();	
		}
	  
	  
	  public static void main(String[] args) {
		  Session session = HibernateUtil.getSessionFactory().openSession();
	    	ControlHealthEntity controlHealthEntity = new ControlHealthEntity(session);
	    	Catalog catalog= (Catalog)session.load(Catalog.class, 1);
	    	controlHealthEntity.insert("3eerr","Salud","direccion","12345",catalog);
	    	//controlHealthEntity.consult("3eerr");
	    	//controlHealthEntity.consultName("Salud");
	    	//controlHealthEntity.lisrHealthEntity("Salud");
//	    	try {
//				controlHealthEntity.remove("3eerr");
//				controlHealthEntity.update("3eerr", "Edrf","tr54", "1234");
//			} catch (ErrorConnection e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}
	

}

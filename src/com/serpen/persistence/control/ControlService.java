package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.google.gwt.aria.client.ListRole;
import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Conection;
import com.serpen.logic.entity.Entity;
import com.serpen.logic.entity.Service;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlService {
	
	private Session session;
	private Transaction transaction;
	
    public ControlService(Session session,Transaction transaction){
    	super();
    	this.session=session;
    	this.transaction=transaction;
    }
    public void insert(int id, String name,double cost){
    	Service service = new Service();
    	service.setId(id);
    	service.setName(name);
    	service.setCost(cost);
    	session.save(service);
    	transaction.commit();
    }
    public Service consult(int id){	
    	Service service =(Service) session.load(Service.class, id) ; 
        System.out.println(service);
        return service;
    }
    public Service consultName(String name){
    	Criteria criteria = session.createCriteria(Service.class);
    	criteria.add(Restrictions.like("name",name));
    	System.out.println((Service)criteria.list().get(0));
    	return  (Service)criteria.list().get(0);
    }
    public List<Service> lisrService(String name){
    	Criteria criteria = session.createCriteria(Service.class);
    	criteria.add(Restrictions.like("name","%"+name+"%"));
    	 for (int i = 0; i < criteria.list().size(); i++) {
   		  criteria.list().get(i);	
   		}
    	return  criteria.list();
    }
    public void remove(int id)throws ErrorConnection{
		Service service = (Service) session.load(Service.class, id);
		session.delete(service);
		transaction.commit();
	}
	public void update(int id,double cost)throws ErrorConnection{
		Service service= (Service) session.load(Service.class, id);
		service.setCost(cost);
		session.update(service);
		transaction.commit();	
	}
    
    
    
    public static void main(String[] args) {
       Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction transaction=session.beginTransaction();
        ControlService controlService = new ControlService(session, transaction);	
  //      controlService.consult(1);
        controlService.insert(1, "odontologia",8.9);
  //  	controlService.consultName("odontologia");
     //  controlService.lisrService("0");
        try {
        	//controlService.remove(1);
//        	controlService.update(1, 10.5);
		} catch (Exception e) {
			// TODO: handle exception
		}   
        session.close();	
	}

}

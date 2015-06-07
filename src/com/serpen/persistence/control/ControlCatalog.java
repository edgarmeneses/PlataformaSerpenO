package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.CareCenter;
import com.serpen.logic.entity.Catalog;
import com.serpen.logic.entity.Service;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlCatalog {
	
	private Session session;
	private Transaction transaction;
	public ControlCatalog(Session session, Transaction transaction) {
		super();
		this.session = session;
		this.transaction = transaction;
	}
	public void insert(int id, double discount , Service service,CareCenter carecenter){
	    	Catalog catalog = new Catalog();
	    	catalog.setId(id);
	    	catalog.setDiscount(discount);
	    	catalog.setCarecenter(carecenter);
	    	catalog.setService(service);
	    	session.save(catalog);
	    	transaction.commit();
	    	
	    }
	 public Catalog consult(int id){	
	    	Catalog catalog = (Catalog) session.load(Catalog.class, id); 
	        return catalog;
	 }
 
	  public void remove(int id)throws ErrorConnection{
			Catalog catalog= (Catalog) session.load(Catalog.class, id);
			session.delete(catalog);
			transaction.commit();
		}
		public void update(int id,double discount )throws ErrorConnection{
			Catalog catalog= (Catalog) session.load(Catalog.class, id);
			catalog.setDiscount(discount);
			session.update(catalog);
			transaction.commit();	
		}
		
		public List<Catalog> list(String name){
			
			Criteria criteria = session.createCriteria(Catalog.class);
	    	return criteria.list();
		}

	public static void main(String[] args) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
	     Transaction transaction=session.beginTransaction();
	     ControlCatalog controlCatalog = new ControlCatalog(session, transaction);
//	     Service service =  (Service)session.load(Service.class,1);
//	     CareCenter carecenter = (CareCenter) session.load(CareCenter.class,"555666-2");
	    // controlCatalog.insert(2, 9.5, service, carecenter);
	    //System.out.println(controlCatalog.consult(1));
	    System.out.println(controlCatalog.list("o"));
	     session.close();
	}
}

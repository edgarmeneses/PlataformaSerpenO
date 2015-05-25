package com.serpen.persistence.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Credit;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlCredit {
	
	Session session;
	//Transaction transaction;
	
	
	public ControlCredit(Session session) {
		this.session = session;
		//this.transaction = transaction;
	}
	
	public void insert(double amount, int share) throws ErrorConnection{
		
		try{
			
			Credit credit = new Credit();
			credit.setAmount(amount);
			credit.setShare(share);
		}catch(Exception e){
			throw new ErrorConnection("No se pudo insertar el credito " + "Causa: "+e.getCause());
		}
		
	}
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		ControlCredit credit = new ControlCredit(session);
		
		try{
			
			credit.insert(1235.9, 123);
			
			session.close();
		}catch(ErrorConnection e){
			e.printStackTrace();
		}
	}

}

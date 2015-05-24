package com.serpen.persistence.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.FinancialEntity;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlFinacialEntity {
	
	Session session;
	Transaction transaction;
	
	
	public ControlFinacialEntity(Session session, Transaction transaction) {
	
		this.session = session;
		this.transaction = transaction;
	}
	
	public void insert (String nit, String name, String address, String  numberPhone)throws ErrorConnection{
		
		try{
			FinancialEntity financialEntity = new FinancialEntity();
			financialEntity.setNit(nit);
			financialEntity.setName(name);
			financialEntity.setAddress(address);
			financialEntity.setNumberPhone(numberPhone);
			
			session.save(financialEntity);
			transaction.commit();
			
		}catch(Exception e){

			throw new ErrorConnection("No se pudo insertar la entidad_financiera " + "Causa: "+e.getCause());
		}
		
		
	}
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		ControlFinacialEntity fEntity = new ControlFinacialEntity(session, transaction);
		
		try{
			
			fEntity.insert("1234", "Pension", "carrera123", "7444056");
			
		}catch(ErrorConnection e){

			e.printStackTrace();

		}
	}

}

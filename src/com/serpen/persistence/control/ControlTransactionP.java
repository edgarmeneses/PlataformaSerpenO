package com.serpen.persistence.control;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.logic.entity.TransactionP;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.error.connection.ErrorConnection;

public class ControlTransactionP {
	
	Session session;
	Transaction transaction;
	
	public ControlTransactionP(Session session, Transaction transaction) {
		this.session = session;
		this.transaction = transaction;
	}
	
	public void insert (char transactionType, double amount,Date date )throws ErrorConnection{
		
		try{
			
			TransactionP transactionP = new TransactionP();
			transactionP.setTrnsactionType(transactionType);
			transactionP.setAmount(amount);
			
//			date = new Date(85, 4, 7);
			transactionP.setDate(date);
			
			session.save(transactionP);
			transaction.commit();
			
		}catch(Exception e){

			throw new ErrorConnection("No se pudo insertar la transaccion " + "Causa: "+e.getCause());
		}
		
		
	}
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		ControlTransactionP cTransaction = new ControlTransactionP(session, transaction);
		
		try{
			
	
			cTransaction.insert('C', 1234.3, new Date(85, 4, 7));
		}catch(ErrorConnection e){

			e.printStackTrace();

		}
	}

}

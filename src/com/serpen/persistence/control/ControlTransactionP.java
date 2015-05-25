package com.serpen.persistence.control;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.logic.entity.Account;
import com.serpen.logic.entity.TransactionP;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.error.connection.ErrorConnection;

public class ControlTransactionP {
	
	Session session;
	//Transaction transaction;
	
	public ControlTransactionP(Session session) {
		this.session = session;
		//this.transaction = transaction;
	}
	
	public void insert (int id, char transactionType, double amount,Date date, Account account)throws ErrorConnection{
		
		try{
			TransactionP transactionP = new TransactionP();
			transactionP.setId(id);
			transactionP.setTransactionType(transactionType);
			transactionP.setAmount(amount);
			transactionP.setAccount(account);
			
//			date = new Date(85, 4, 7);
			transactionP.setDate(date);
			
			session.save(transactionP);
			session.beginTransaction().commit();
			//transaction.commit();
			
		}catch(Exception e){

			throw new ErrorConnection("No se pudo insertar la transaccion " + "Causa: "+e.getCause());
		}
		
		
	}
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction transaction = session.beginTransaction();

		ControlTransactionP cTransaction = new ControlTransactionP(session);
		
		try{
			
	
			cTransaction.insert(id,TransactionP.ENTRY, 1234.3, new Date(85, 4, 7), account);//(TransactionP.ENTRY, 1234.3, new Date(85, 4, 7));
			
		}catch(ErrorConnection e){

			e.printStackTrace();

		}
	}

}

package com.serpen.persistence.control;


import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.logic.entity.Account;
import com.serpen.logic.entity.Catalog;
import com.serpen.logic.entity.FinancialEntity;
import com.serpen.logic.entity.TransactionP;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.error.connection.ErrorConnection;
/**
 * Clase que permite el insertar, listar y consultar datos 
 * de la base de datos en especial la entidad transaccion 
 * @author Diana Gonzalez, Edgar Menese, Eliana Ayala, Daniela Blnaco
 *
 */
public class ControlTransactionP {
	
	Session session;

	/**
	 * Constructor de la clase 
	 * @param session
	 */
	public ControlTransactionP(Session session) {
		
		this.session = session;
	}
	/**
	 * Meto insertar para agregar nuevos datos a la 
	 * base de datos 
	 * @param id
	 * @param transactionType
	 * @param amount
	 * @param date
	 * @param account
	 * @throws ErrorConnection
	 */
	public void insert (int id, char transactionType, double amount,Date date, Account account)throws ErrorConnection{
		
		try{
			TransactionP transactionP = new TransactionP();
			transactionP.setId(id);
			transactionP.setTransactionType(transactionType);
			transactionP.setAmount(amount);
			transactionP.setAccount(account);
			transactionP.setDate(date);
			
			session.save(transactionP);
			session.beginTransaction().commit();
			
		}catch(Exception e){

			throw new ErrorConnection("No se pudo insertar la transaccion " + "Causa: "+e.getCause());
		}
		
		
		
	}
	/**
	 * Metodo que permite listar los datos que estan en la entidad 
	 * Transaccion en la base de datos 
	 * @return
	 * @throws ErrorConnection
	 */
		
	public List<TransactionP> list(int account) throws ErrorConnection{
		try{
			String sql = "from com.serpen.logic.entity.TransactionP u " +
					"WHERE u.account.number = "+ account;

			List<TransactionP> listaTransacion = session.createQuery(sql).list();
            System.out.println(listaTransacion);
			return listaTransacion;
		}catch(Exception e){
			throw new ErrorConnection("No se pudo realizar la consulta"
					+ " Causa: "+e.getCause());
		}
	}
	
//public List<TransactionP> list( int id){
//		
//		Criteria criteria = session.createCriteria(TransactionP.class);
//    	return criteria.list();
//	}
	/**
	 * Metodo que permite consultar un dato de la entidad transaccion 
	 * por medio de id 
	 * @param id
	 * @return
	 * @throws ErrorConnection
	 */
	public TransactionP consult(int id) throws ErrorConnection{

		TransactionP transactionP=(TransactionP) session.load(TransactionP.class, id);
		System.out.println("--------------------------------------------------");
		System.out.println(transactionP);

		if(transactionP != null){
			return transactionP;
		}
		else{
			throw new ErrorConnection("no se enconto ninguna trasaccion ");

		}

	}
	
	public TransactionP consult2(Date date) throws ErrorConnection{

		TransactionP transactionP=(TransactionP) session.load(TransactionP.class, date);
		System.out.println("--------------------------------------------------");
		System.out.println(transactionP);

		if(transactionP != null){
			return transactionP;
		}
		else{
			throw new ErrorConnection("no se enconto ninguna trasaccion ");

		}

	}
	public static void main(String[] args) throws ErrorConnection {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		ControlTransactionP cTransaction = new ControlTransactionP(session);
		
		ControlAccount account = new ControlAccount(session);
		System.out.println(cTransaction.list(123));
//		Account account2 = account.consult(123);
		
//		Date date = new Date(112,7,7);// 2012-08-07

//		cTransaction.insert(15,TransactionP.RETREAT, 1234.3, date,account2);
		
//		System.out.println(cTransaction.consult(13));

		
//		try{
//			
////			cTransaction.insert(10,TransactionP.ENTRY, 1234.3, date,account2);
////			cTransaction.list();
////			cTransaction.consult(10);
//		
//			
//		}catch(ErrorConnection e){
//
//			e.printStackTrace();
//
//		}
	}

}

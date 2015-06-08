package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Account;
import com.serpen.logic.entity.Catalog;
import com.serpen.logic.entity.FinancialEntity;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.TransactionP;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;
/**
 * Clase que permite insertar, consultar y listar datos a 
 * la base de datos de la entidad cuenta 
 * @author Diana Gonzalez, Edgar Menese, Eliana Ayala, Daniela Blnaco
 *
 */
public class ControlAccount {

	Session session;

	/**
	 * Constructor de la clas e
	 * @param session
	 */
	public ControlAccount(Session session) {

		this.session = session;
	}

	/**
	 * Meto que permite insertar un nuevo dato 
	 * a la base de datos 
	 * @param numero
	 * @param tipocuenta
	 * @param user
	 * @param financiera
	 * @throws ErrorConnection
	 */

	public void insert (int numero, String tipocuenta, User user, FinancialEntity  financiera)throws ErrorConnection{

		try{

			Account account= new Account();
			account.setNumber(numero);
			account.setAccountType((tipocuenta));
			account.setUser(user);
			account.setFinancialEntity(financiera);

			session.save(account);
			session.beginTransaction().commit();

		}catch(Exception e){

			throw new ErrorConnection("No se pudo insertar la cuenta " + "Causa: "+e.getCause());
		}


	}

	/**
	 * Metodo que permite consultar un determinado 
	 * dato en la base de datos 
	 * @param numer
	 * @return
	 * @throws ErrorConnection
	 */

	public Account consult(int numer) throws ErrorConnection{

		Account account=(Account) session.load(Account.class, numer);

		if(account != null){
			return account;
		}
		else{
			throw new ErrorConnection("no se enconto ninguna cuenta");

		}

	}
	
	public List<Account> list(String typeAccount){
		
		Criteria criteria = session.createCriteria(Account.class);
    	return criteria.list();
	}
	
	public static void main(String[] args) throws ErrorConnection {

		Session session = HibernateUtil.getSessionFactory().openSession();
        TransactionP transactionP = (TransactionP) session.load(TransactionP.class, 10);
        
		ControlAccount cAccount = new ControlAccount(session);
		Account account = new Account();
		ControlUser user= new ControlUser(session);
		User user2 = user.consultId(100794);

		ControlFinacialEntity fEntity = new ControlFinacialEntity(session);
		FinancialEntity fEntity2 = fEntity.consult("123");
        System.out.println(account.stateAccount(transactionP));
        
//		try{
			
//			cAccount.insert(123,Account.CERTIFICADO_DE_DEPOSITO,user2,fEntity2);
//			System.out.println(cAccount.list("C"));
//			cAccount.insert(13,Account.CERTIFICADO_DE_DEPOSITO,user2,fEntity2);

//			List<Account> accounts = cAccount.list();
//			System.out.println("Cuentas");
//			
//			for (Account account : accounts) {
//				System.out.println(account);
//			}
//			
//			System.out.println("cuenta");
//			
//			System.out.println(cAccount.consult(12));
//			
////			cAccount.consult(1234);

//		}catch(ErrorConnection e){
//
//			e.printStackTrace();
//
//		}
	}
	
//	public static void main (){
//		
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		ControlAccount account = new ControlAccount(session);
//		User user = (User) session.load(User.class, 100794);
//		FinancialEntity financiera = (FinancialEntity) session.load(FinancialEntity.class, 1234);
//
//		try {
//			account.insert(111111, Account.CUENTA_CORRIENTE, user, financiera);
//			session.close();
//		} catch (ErrorConnection e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
// 		
//	}

}

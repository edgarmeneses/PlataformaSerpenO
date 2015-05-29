package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Account;
import com.serpen.logic.entity.FinancialEntity;
import com.serpen.logic.entity.Role;
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
	 * Metodo que permite listar los datoa que contiene la 
	 * base de datos 
	 * @return
	 * @throws ErrorConnection
	 */
	public List<Account> list() throws ErrorConnection{

		try{

			List<Account> lisAccounts = session.createQuery(
					"from cuenta "+
					"in class com.serpen.logic.entity.Account").list();
			for (int i = 0; i < lisAccounts.size(); i++) {
				Account pAccount = lisAccounts.get(i);
			}
			if (!lisAccounts.isEmpty()){

				return lisAccounts;
			}else{

				throw new ErrorConnection("No se cuenta con ningun dato de la cuenta");
			}
		}catch(Exception e){
			throw new ErrorConnection("no se pudo realizar la conexion "
					+ " Causa: " + e.getCause());

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
	
	public static void main(String[] args) throws ErrorConnection {

		Session session = HibernateUtil.getSessionFactory().openSession();

		ControlAccount cAccount = new ControlAccount(session);

		ControlUser user= new ControlUser(session);
		User user2 = user.consultId(1049635);

		ControlFinacialEntity fEntity = new ControlFinacialEntity(session);
		FinancialEntity fEntity2 = fEntity.consult("1234");


		try{
			
			cAccount.insert(123,Account.CERTIFICADO_DE_DEPOSITO,user2,fEntity2);
			cAccount.insert(13,Account.CERTIFICADO_DE_DEPOSITO,user2,fEntity2);

			List<Account> accounts = cAccount.list();
			System.out.println("Cuentas");
			
			for (Account account : accounts) {
				System.out.println(account);
			}
			
			System.out.println("cuenta");
			
			System.out.println(cAccount.consult(12));
			
//			cAccount.consult(1234);

		}catch(ErrorConnection e){

			e.printStackTrace();

		}
	}

}

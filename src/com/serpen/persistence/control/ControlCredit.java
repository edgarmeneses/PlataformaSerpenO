package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Account;
import com.serpen.logic.entity.Credit;
import com.serpen.logic.entity.FinancialEntity;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;
/**
 * Esta clase permite insertar, listar y consultar informacion 
 * de la entidad Credito de la base de datos 
 * @author Diana Gonzalez, Edgar Menese, Eliana Ayala, Daniela Blnaco
 *
 */
public class ControlCredit {

	Session session;

	/**
	 * Constructor de la clase 
	 * @param session
	 */
	public ControlCredit(Session session) {
		this.session = session;
	}
	/**
	 * Metodo para insertar informacion a la base de datos 
	 * @param id
	 * @param amount
	 * @param share
	 * @param user
	 * @param financialEntity
	 * @throws ErrorConnection
	 */
	public void insert(int id,double amount, int share, User user, FinancialEntity financialEntity) throws ErrorConnection{

		try{

			Credit credit = new Credit();
			credit.setId(id);
			credit.setAmount(amount);
			credit.setShare(share);
			credit.setUser(user);
			credit.setFinancialEntity(financialEntity);

			session.save(credit);
			session.beginTransaction().commit();


		}catch(Exception e){
			throw new ErrorConnection("No se pudo insertar el credito " + "Causa: "+e.getCause());
		}

	}
	/**
	 * Metodo para listar los datos que contien 
	 * la base de datos 
	 * @return
	 * @throws ErrorConnection
	 */

	public List<Credit> list() throws ErrorConnection{

		try{

			List<Credit> lisCredit = session.createQuery(
					"from credito "+
					"in class com.serpen.logic.entity.Credit").list();
			for (int i = 0; i < lisCredit.size(); i++) {
				Credit credit = lisCredit.get(i);
				System.out.println("------------------------------");
				System.out.println(credit);

			}
			if (!lisCredit.isEmpty()){

				return lisCredit;
			}else{

				throw new ErrorConnection("No se cuenta con ningun dato del credito");
			}
		}catch(Exception e){
			throw new ErrorConnection("no se pudo realizar la conexion "
					+ " Causa: " + e.getCause());

		}

		/**
		 * Metodo para consultar por medio del id 
		 * un dato de la base de datos 
		 */
	}
	public Credit consult(int id) throws ErrorConnection{

		Credit credit=(Credit) session.load(Credit.class, id);
		System.out.println("--------------------------------------------------");
		System.out.println(credit);

		if(credit != null){
			return credit;
		}
		else{
			throw new ErrorConnection("no se enconto ningun credito");

		}

	}

	public static void main(String[] args) throws ErrorConnection {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		ControlCredit credit = new ControlCredit(session);

		ControlUser user= new ControlUser(session, transaction);
		User user2 = user.consultId(1049635);

		ControlFinacialEntity fEntity = new ControlFinacialEntity(session);
		FinancialEntity fEntity2 = fEntity.consult("1234");

		try{

//			credit.insert(1,123.3,123,user2,fEntity2);
//			credit.list();
			credit.consult(2);

			session.close();
		}catch(ErrorConnection e){
			e.printStackTrace();
		}
	}

}

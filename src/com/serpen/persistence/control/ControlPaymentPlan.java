package com.serpen.persistence.control;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Account;
import com.serpen.logic.entity.Credit;
import com.serpen.logic.entity.FinancialEntity;
import com.serpen.logic.entity.PaymentPlan;
import com.serpen.logic.entity.TransactionP;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;

/**
 * Esta Clase permite realizar inserciones, listar y consultar 
 * los datos de la base de datos en especial la entidad plan de pago 
 * @author Diana Gonzalez, Edgar Menese, Eliana Ayala, Daniela Blnaco
 *
 */
public class ControlPaymentPlan {

	Session session;


	/**
	 * Constructor de la calse 
	 * @param session
	 */
	public ControlPaymentPlan(Session session) {

		this.session = session;
	}
	
	/**
	 * Metodo que permite ingresar nuevos datos a la base de datos 
	 * @param quotaNumber
	 * @param paymntDate
	 * @param amount
	 * @param credit
	 * @throws ErrorConnection
	 */

	public void insert(int quotaNumber, Date paymntDate, double amount, Credit credit) throws ErrorConnection{

		try{

			PaymentPlan paymentPlan= new PaymentPlan();
			paymentPlan.setQuotaNumber(quotaNumber);
			paymentPlan.setPaymntDate(paymntDate);
			paymentPlan.setAmount(amount);
			paymentPlan.setCredit(credit);

			session.save(paymentPlan);
			session.beginTransaction().commit();

		}catch(Exception e){

			throw new ErrorConnection("No se pudo insertar el plan de pago  " + "Causa: "+e.getCause());
		}
	}
	
	/**
	 * Metodo que permite listar todos los datos que contiene la entidad 
	 * plan _pago en la base de datos 
	 * @return
	 * @throws ErrorConnection
	 */
	
	public List<PaymentPlan> list() throws ErrorConnection{

		try{

			List<PaymentPlan> listPaymentPlan = session.createQuery(
					"from plan_pago "+
					"in class com.serpen.logic.entity.PaymentPlan").list();
			System.out.println("------------------------------------");
			
			for (int i = 0; i < listPaymentPlan.size(); i++) {
				PaymentPlan paymentPlan = listPaymentPlan.get(i);
				
				System.out.println(paymentPlan);

			}
			if (!listPaymentPlan.isEmpty()){

				return listPaymentPlan;
			}else{

				throw new ErrorConnection("No se cuenta con ningun dato del plan de pago ");
			}
		}catch(Exception e){
			throw new ErrorConnection("no se pudo realizar la conexion "
					+ " Causa: " + e.getCause());

		}
		
		

	}
	
	/**
	 * Metodo que permite realizar una consulta a uno de los datos qu contiene 
	 * la entidad plande pago de la base de datos 
	 * 
	 * @param quotaNumber
	 * @return
	 * @throws ErrorConnection
	 */
	
	public PaymentPlan consult(int quotaNumber) throws ErrorConnection{

		PaymentPlan paymentPlan=(PaymentPlan) session.load(PaymentPlan.class, quotaNumber);
		System.out.println("--------------------------------------------------");
		System.out.println(paymentPlan);

		if(paymentPlan != null){
			return paymentPlan;
		}
		else{
			throw new ErrorConnection("no se enconto ningun plan de pago  ");

		}

	}
	public static void main(String[] args) throws ErrorConnection {

		Session session = HibernateUtil.getSessionFactory().openSession();

		ControlPaymentPlan controlPaymentPlan = new ControlPaymentPlan(session);

		ControlCredit controlCredit = new ControlCredit(session);
		Credit credit = controlCredit.consult(2);

		Date date = new Date(112,7,7);// 2012-08-07



		try{

//			controlPaymentPlan.insert(456, date, 3948.0, credit);
//			controlPaymentPlan.list();
			controlPaymentPlan.consult(1);
		}catch(ErrorConnection e){

			e.printStackTrace();

		}
	}
}

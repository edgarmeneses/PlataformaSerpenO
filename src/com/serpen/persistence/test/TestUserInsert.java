package com.serpen.persistence.test;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.logic.entity.PensionFund;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;

public class TestUserInsert {
public static void main(String[] args) {
		
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
		try {
		
			Role role = new Role(2,"Cliente");
			session.save(role);
			PensionFund pensionFund = new PensionFund("1111-1a", "Corpobanca", 8.5);
			session.save(pensionFund);
			
			User user = new User(1, "constraseña", "respuesta", role,"Juan", "Perez", "direccion", "312456476", "Algarra", 100.00, User.AFFILIATE_TYPE_CONTRIBUTOR, pensionFund);
		    session.save(user);
		    transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
		}
		
	}
}

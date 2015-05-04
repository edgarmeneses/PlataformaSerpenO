package com.serpen.persistence.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Conection;
import com.serpen.logic.entity.Entity;
import com.serpen.logic.entity.PensionFund;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlGeneral;

public class TestControlGeneral {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {  	    
		    //Entity entity = new Entity("1345-1", "Corp", Entity.ENTITY_TYPE_TOURISM, "descripcion");
		    //session.save(entity);
			Entity entity = new Entity(1,"av", "SantoTomas", Entity.ENTITY_TYPE_HOUSING, "Entidad tipo vivienda");
			session.save(entity);
		    Conection conection =  new Conection(3,"com.mysql.jdbc.Driver",3306,"Educacion");
		    session.save(conection);
		    transaction.commit();
		    session.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
		}
	}
}

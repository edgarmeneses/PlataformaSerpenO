package com.serpen.persistence.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.logic.entity.Entity;
import com.serpen.persistence.conf.HibernateUtil;

public class TestEntidadInsert {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction= session.beginTransaction();
		Entity entity = new Entity(1,"4023-a", "UPTC", Entity.ENTITY_TYPE_EDUCATION, "uptc");
		session.save(entity);
		transaction.commit();
		session.close();
		
	}

}

package com.serpen.persistence.test;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.logic.entity.Agreement;
import com.serpen.logic.entity.Entity;
import com.serpen.logic.entity.PensionFund;
import com.serpen.persistence.conf.HibernateUtil;

public class TestConvenioInsert {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();	
		PensionFund pensionFund = new PensionFund("12","FondoSanar",8.5);
		session.save(pensionFund);
		Entity entity = new Entity(1,"1231","educacion",Entity.ENTITY_TYPE_EDUCATION,"esgttgsusjsj");
		session.save(entity);
		Agreement agreement = new Agreement(1, 8.5, entity, pensionFund);
		session.save(agreement);	
		transaction.commit();
		session.close();
	}

}

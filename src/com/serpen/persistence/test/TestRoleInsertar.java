package com.serpen.persistence.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.logic.entity.Role;
import com.serpen.persistence.conf.HibernateUtil;

public class TestRoleInsertar {
	public static void main(String[] args) {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Role role = (Role) session.load(Role.class, 1);
			role = new Role(2,"Administrador");
			
			session.save(role);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}

}

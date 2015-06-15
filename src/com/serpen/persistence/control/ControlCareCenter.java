package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.CareCenter;
import com.serpen.logic.entity.Service;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlCareCenter {

	Session session;

	public ControlCareCenter(Session session) {
		// TODO Auto-generated constructor stub
		this.session=session;
	}

	public CareCenter consult(String nit){	
		CareCenter careCenter =(CareCenter) session.load(CareCenter.class, nit) ; 
		return careCenter;
	}

	public CareCenter consultName(String name){
		Criteria criteria = session.createCriteria(CareCenter.class);
		criteria.add(Restrictions.like("name",name));
		return  (CareCenter)criteria.list().get(0);
	}

	public void insert(String nit, String name,String address,String phone){
		CareCenter careCenter = new CareCenter();
		careCenter.setNit(nit);
		careCenter.setName(name);
		careCenter.setAddress(address);
		careCenter.setPhone(phone);	    	
		session.save(careCenter);
		session.beginTransaction().commit();
	}

	public List<CareCenter> list(String name){
		Criteria criteria = session.createCriteria(CareCenter.class);
		criteria.add(Restrictions.like("name","%"+name+"%"));

		return  criteria.list();
	}
	
	public List<CareCenter> list(){
		Criteria criteria = session.createCriteria(CareCenter.class);
		return criteria.list();
	}
	public void remove(String nit)throws ErrorConnection{
		CareCenter careCenter = (CareCenter) session.load(CareCenter.class, nit);
		session.delete(careCenter);
		session.beginTransaction().commit();
	}
	public void update(String nit,String name,String address,String phone)throws ErrorConnection{
		CareCenter careCenter= (CareCenter) session.load(CareCenter.class, nit);
		careCenter.setName(name);
		careCenter.setAddress(address);
		careCenter.setPhone(phone);
		session.update(careCenter);
		session.beginTransaction().commit();	
	}
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction= session.beginTransaction();
		ControlCareCenter controlCareCenter= new ControlCareCenter(session);
		// controlCareCenter.insert("555666-2", "SaludCoop","339djdjdjdj","23455666");	
		// controlCareCenter.consult("555666-2");
		//controlCareCenter.consultName("SaludCoop");
		// controlCareCenter.lisrService("S");

		//controlCareCenter.insert("555666-2", "SaludCoop","339djdjdjdj",23455666);
		//	controlCareCenter.remove("555666-2");
		try {
			controlCareCenter.update("555666-2", "Salud", "45ff55","123456");
		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

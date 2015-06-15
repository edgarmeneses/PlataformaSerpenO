package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Entity;
import com.serpen.logic.entity.ServiceFund;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;

/**
 * Universidad Pedagogica y Tecnologica de Colombia
 * @author Eliana Ayala
 * 		   Daniela Blanco
 * 		   Diana Gonzalez
 * 	       Edgar Meneces
 *Clase  que se  tiene los controles de servicio fondo
 */
public class ControlServiceFund {
	
	Session session;
	
	public  ControlServiceFund(Session session){
		this.session = session;
		
	}
	/**
	 * Metodo que se encarga de insertar un servicio fondo en la base de datos
	 * @param id
	 * @param name
	 * @param value
	 * @param description
	 * @param discount
	 * @param interest
	 * @param information
	 * @param duration
	 * @param entity
	 */
	public void insert (int id , String name , double value , String description , double discount , double interest, String information, String duration, Entity entity){
		
		ServiceFund serviceFund = new ServiceFund();
		serviceFund.setId(id);
		serviceFund.setName(name);
		serviceFund.setValue(value);
		serviceFund.setDescription(description);
		serviceFund.setDiscount(discount);
		serviceFund.setInterest(interest);
		serviceFund.setInformation(information);
		serviceFund.setDuration(duration);
		serviceFund.setEntity(entity);
		session.save(serviceFund);
		session.beginTransaction().commit();
		
	}
	
	/**
	 * metodo que se encarga de consultar el servicio fondo por el id
	 * @param id
	 * @return
	 * @throws ErrorConnection
	 */
	public ServiceFund consultId(int id) throws ErrorConnection{
		
	ServiceFund serviceFund = (ServiceFund) session.load(ServiceFund.class,id);
	return serviceFund;
				
	}
	
	/**
	 * Consultar por el nombre del servicio de fondo
	 * @param name
	 * @return
	 * @throws ErrorConnection
	 */
	public ServiceFund consutlName(String name) throws ErrorConnection{
		Criteria criteria = session.createCriteria(ServiceFund.class);
		criteria.add(Restrictions.like("name",name));
		return (ServiceFund) criteria.list().get(0);
		
	}
	/**
	 * MEtodo que se encarga de cactualizar los servicio del fondo
	 * @param id
	 * @param name
	 * @param value
	 * @param description
	 * @param discount
	 * @param interest
	 * @param information
	 * @param duration
	 * @param entity
	 * @throws ErrorConnection 
	 */
	public void update (int id , String name , double value , String description , double discount , double interest, String information, String duration, Entity entity) throws ErrorConnection{
		ServiceFund serviceFund = consultId(id);
		serviceFund.setName(name);
		serviceFund.setValue(value);
		serviceFund.setDescription(description);
		serviceFund.setDiscount(discount);
		serviceFund.setInterest(interest);
		serviceFund.setInformation(information);
		serviceFund.setDuration(duration);
		serviceFund.setEntity(entity);
		session.update(serviceFund);
		session.beginTransaction().commit();
	}
	
	/**
	 * eliminar servicio fondo
	 * @param id
	 * @throws ErrorConnection
	 */
	public void remove(int id) throws ErrorConnection{
		ServiceFund serviceFund = consultId(id);
		session.delete(serviceFund);
		session.beginTransaction().commit();
				
	}
	
	public List<ServiceFund> listoServiceFund (String name){
		Criteria criteria = session.createCriteria(ServiceFund.class);
		criteria.add(Restrictions.like("name", "%"+name+"%"));	
		return criteria.list();	
		
	}
	
	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactory().openSession();
		ControlServiceFund controlServiceFund= new ControlServiceFund(session);
		Entity entity  = (Entity) session.load(Entity.class, 1);
		controlServiceFund.insert(1, "Educativo", 456.99, "Setvicio que se ",45.7,4, "trfff", "gyyuu", entity);
		
		
	}
}

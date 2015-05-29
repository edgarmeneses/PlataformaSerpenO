package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.google.gwt.aria.client.ListRole;
import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Conection;
import com.serpen.logic.entity.Entity;
import com.serpen.logic.entity.Service;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlService {
	
	Session session;
	
    public ControlService(Session session){
    	this.session=session;
    }
    /**
     * Metodo para insertar un servicio
     * @param id
     * @param name
     * @param cost
     */
    public void insert(int id, String name,double cost){
    	Service service = new Service();
    	service.setId(id);
    	service.setName(name);
    	service.setCost(cost);
    	session.save(service);
    	session.beginTransaction().commit();
    }
    /**
     * Consulta in servicio de aucerdo al identificador de este (id)
     * @param id
     * @return
     */
    public Service consult(int id){	
    	Service service =(Service) session.load(Service.class, id) ; 
        return service;
    }
    /**
     * Consulta un servicio por su nombre
     * @param name
     * @return
     */
    public Service consultName(String name){
    	Criteria criteria = session.createCriteria(Service.class);
    	criteria.add(Restrictions.like("name",name));
    	return  (Service)criteria.list().get(0);
    }
    /**
     * lista todos los servicios insertados en la base de datos 
     * @return
     */
    public List<Service> list(){
    	Criteria criteria = session.createCriteria(Service.class);
    	return criteria.list();
    }
    /**
     * hace un fitrado de servicios de acuerdo a una palabra clave
     * @param name
     * @return
     */
    public List<Service> list(String name){
    	Criteria criteria = session.createCriteria(Service.class);
    	criteria.add(Restrictions.like("name","%"+name+"%"));
    	return  criteria.list();
    }
    /**
     * permite eliminar un servicio
     * @param id
     * @throws ErrorConnection
     */
    public void remove(int id)throws ErrorConnection{
		Service service = (Service) session.load(Service.class, id);
		session.delete(service);
		session.beginTransaction().commit();
	}
    /**
     * permite modificar el costo de un servicio
     * @param id
     * @param cost
     * @throws ErrorConnection
     */
	public void update(int id,double cost)throws ErrorConnection{
		Service service= (Service) session.load(Service.class, id);
		service.setCost(cost);
		session.update(service);
		session.beginTransaction().commit();	
	}
}

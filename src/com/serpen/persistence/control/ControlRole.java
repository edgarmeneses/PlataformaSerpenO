package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.RoleHistory;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlRole {

	Session session;

	public ControlRole(Session sesion) {
		this.session = sesion;
	}

	public void insert(String name) throws ErrorConnection{

		try{
			Role role = new Role();
			role.setName(name);
			session.save(role);
			session.beginTransaction().commit();
		}catch(Exception e){

			throw new ErrorConnection("No se pudo insertar el rol " + "Causa: "+e.getCause());
		}

	}

	public List<Role> list(){
		Criteria criteria = session.createCriteria(Role.class);
		return criteria.list();
	}

	public List<Role> list(String name){
		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.like("name", "%"+name+"%"));
		return criteria.list();
	}

	public Role consult(int id) throws ErrorConnection{
		try{
			Role role = new Role();
			role = (Role) session.load(Role.class,id);
			return role;

		}catch(Exception e){
			throw new ErrorConnection("no se pudo conectar al rol"
					+ " Causa: "+e.getCause());
		}
	}

	public Role consultName(String name) throws ErrorConnection{

		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.like("name", name));
		return (Role) criteria.list().get(0);
	}


	public void remove(int id, ControlHistoryRole controlHistoryRole,
			ControlUser controlUser, ControlHistoryUser controlHistoryUser) throws ErrorConnection{

		//		//----------- Falta (o"o) ---------------------

	}

	public void upDate(int id,String nombre)throws ErrorConnection{

		try{
			Role role = consult(id);
			role.setId(id);
			role.setName(nombre);  
			session.update(role);
			session.beginTransaction().commit();
		}catch(Exception e){

			throw new ErrorConnection("El rol ingresado no se encuentra"+"Causa: "+e.getCause());
		}
	}
}
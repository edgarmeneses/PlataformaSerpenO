package com.serpen.persistence.control;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.serpen.logic.entity.Conection;
import com.serpen.logic.entity.Entity;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlEntity {
	
	private Session session;

	public ControlEntity(Session session) {
		super();
		this.session = session;
	}
	/**
	 * permite insertar en la BD una entidad
	 * @param id
	 * @param nit_entity
	 * @param name
	 * @param entityType
	 * @param description
	 */
	public void insert(int id,String nit_entity, String name, char entityType,
			String description){
		
		Entity entity = new Entity();
		entity.setId(id);
		entity.setNit(nit_entity);
		entity.setName(name);
		entity.setEntityType(entityType);
		entity.setDescription(description);
	
		entity.setConection(null);
		session.save(entity);
		session.beginTransaction().commit();

	}
	/**
	 * metodo que permite listar todas las entidades
	 * @return
	 */
	public List<Entity> list(){
		Criteria criteria = session.createCriteria(Entity.class);
		return criteria.list();
	}
	/**
	 * metodo que permite listar las entidades pero hacer un filtrado por nombre
	 * @param nit
	 * @return
	 */
	public List<Entity> list(String nit){
		Criteria criteria = session.createCriteria(Entity.class);
		criteria.add(Restrictions.like("nit", "%"+nit+"%"));
		return criteria.list();
		
	}
	/**
	 * metodo que permite consultar una entidad segun su nit
	 * @param nit
	 * @return
	 */
	public Entity consult(String nit){
		Criteria criteria = session.createCriteria(Entity.class);
		criteria.add(Restrictions.like("nit",nit));
		return (Entity) criteria.list().get(0);
	}
	
	public void upDate(String nit, String name, char entityType, String description, Conection conection){
			Entity entity=consult(nit);
			entity.setName(name);
			entity.setEntityType(entityType);
			entity.setDescription(description);
			entity.setConection(conection);
			
			session.update(entity);
			session.beginTransaction().commit();
	}
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ControlEntity entity = new ControlEntity(session);
		entity.insert(2, "Nit-123", "Colpesiones", Entity.ENTITY_TYPE_EDUCATION , "poerurjrjrjrjrjrj");
		//System.out.println(entity.consult("103890-70"));
	}

}
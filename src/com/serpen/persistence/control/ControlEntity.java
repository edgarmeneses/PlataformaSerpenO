package com.serpen.persistence.control;

import org.hibernate.Session;

import com.serpen.logic.entity.Entity;

public class ControlEntity {
	
	private Session session;

	public ControlEntity(Session session) {
		super();
		this.session = session;
	}
	
	public void insert(int id, String description){
		Entity entity = new Entity();
		entity.setId(id);
		entity.setDescription(description);
		//entity.setEntityType(entityType);
	}

}

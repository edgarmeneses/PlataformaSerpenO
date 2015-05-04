package com.serpen.logic.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase entidad
 * esta clase contiene las entidades de educacion, turismo
 * y vivienda que interactuan en la aplicacion
 * @author Diana
 *
 */

public class Entity {

	/**
	 * Atributos de la clase, segun la base de datos 
	 */
	private int id;
	private String nit;
	private Conection conection;
	private String name;
	private char entityType;
	private String description;
	private Set<Agreement> agreements;
	/**
	 * Tipos de entidad
	 * sea Educacion, vivienda y turismo 
	 */
	public static final char ENTITY_TYPE_EDUCATION='E';
	public static final char ENTITY_TYPE_HOUSING='V';
	public static final char ENTITY_TYPE_TOURISM='T';
	/**
	 * Constructor vacio de la clase 	
	 */
	public Entity() {
		this.agreements = new HashSet<Agreement>();
		this.conection=new Conection();
	}
	/**
	 * Constructor con los atributos de la clase 
	 * @param nit_entity
	 * @param id
	 * @param name
	 * @param type_entity
	 * @param description
	 */
	public Entity(int id,String nit_entity, String name, char entityType,
			String description) {
		this.id=id;
		this.nit = nit_entity;
		this.conection = new Conection();
		this.name = name;
		this.entityType = entityType;
		this.description = description;
		this.agreements = new HashSet<Agreement>();
	}
	/**
	 * Getters y Setters de cada uno de los atributos 
	 * @return
	 */
	
	public String getNit() {
		return nit;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNit(String nit_entity) {
		this.nit = nit_entity;
	}


	public Conection getConection() {
		return conection;
	}
	public void setConection(Conection conection) {
		this.conection = conection;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getEntityType() {
		return entityType;
	}

	public void setEntityType(char entityType) {
		this.entityType = entityType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Agreement> getAgreements() {
		return agreements;
	}
	
	public void setAgreements(Set<Agreement> agreements) {
		this.agreements = agreements;
	}

	/**
	 * Metodo tostring que retorna todos los atributos de la clase 
	 */
	@Override
	public String toString() {
		return "Entity [nit=" + nit + ", conection=" + conection + ", name="
				+ name + ", entityType=" + entityType + ", description="
				+ description + ", agreements=" + agreements + "]";
	}
}

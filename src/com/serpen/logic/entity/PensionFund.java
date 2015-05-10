package com.serpen.logic.entity;

import java.util.Set;

import com.google.gwt.dev.util.collect.HashSet;

public class PensionFund {
	/**
	 * nit del fondo de penciones
	 */
	private String nit;
	/**
	 * nombre del fondo de penciones
	 */
	private String name;
	/**
	 * porcentaje que el fondo aplica a las cesantias de un usuario
	 */
	private double  porcent;
	
	private Set<Agreement> collectionAgreement;
	
	private Set<User> collectionUser;
	/**
	 * constructor por omicion de la clase PensionFund.java
	 */
	public PensionFund() {
		// TODO Auto-generated constructor stub
		collectionAgreement = new HashSet<Agreement>();
		collectionUser = new HashSet<User>();
		
	}
/**
 * Constructor de la clase PensionFund.java
 * se debe ingresar los valores para los atributos de la clase
 * @param nit
 * @param name
 * @param porcent
 * @param collectionEntity
 */
	public PensionFund(String nit, String name, double porcent) {
	
		this.nit = nit;
		this.name = name;
		this.porcent = porcent;
		this.collectionAgreement = new HashSet<Agreement>();
		this.collectionUser = new HashSet<User>();
	}
	/**
	 * retorna el nit del fondo 
	 * @return nit
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * asigna un valor al nit
	 * @param nit
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}
	/**
	 * retorna el nombre del fondo
	 * @return nombre
	 */
	public String getName() {
		return name;
	}
	/**
	 * asigna un nombre al fondo
	 * @param name nombre
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * retorna el pocentaje que el fondo aplica a las cesantias
	 * @return porcentaje
	 */

	/**
	 * Set como conexion para el mapeo 
	 * @return
	 */
	public Set<Agreement> getCollectionAgreement() {
		return collectionAgreement;
	}
	public double getPorcent() {
		return porcent;
	}
	public void setPorcent(double porcent) {
		this.porcent = porcent;
	}
	public void setCollectionAgreement(Set<Agreement> collectionAgreement) {
		this.collectionAgreement = collectionAgreement;
	}
	public Set<User> getCollectionUser() {
		return collectionUser;
	}
	public void setCollectionUser(Set<User> collectionUser) {
		this.collectionUser = collectionUser;
	}
	/**
	 * metodo delegado toString
	 */
	@Override
	public String toString() {
		return "PensionFund [nit=" + nit + ", name=" + name + ", porcent="
				+ porcent + "]";
	}
	

}

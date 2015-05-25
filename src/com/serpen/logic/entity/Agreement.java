package com.serpen.logic.entity;

import com.serpen.logic.entity.Entity;

/**
 * Clase Convenio 
 * Esta clase permite la conexion con Entidad y Fondo.
 * Tambien contiene el beneficio del convenio de las entidades
 * @author Diana
 *
 */

public class Agreement {

	/**
	 * 	Atributos de la calse Agreement
	 * 	instanciando las clases PensionFund y Entity
	 */
	private int id;
	private PensionFund nit;
	private Entity nitEntity;
	private double benefit;
	/**
	 * Constructor vacio 	
	 */
	public Agreement() {

	}
	/**
	 * Contructor con cada uno de los atributos de la clase
	 * 	
	 * @param nit
	 * @param nitEntity
	 * @param benefit
	 */
	public Agreement(int id,double benefit, Entity nitEntity,PensionFund nit ) {

		this.nit = nit;
		this.nitEntity = nitEntity;
		this.benefit = benefit;
		this.id=id;
	}
	/**
	 * Getters y Setters de los atibutos 
	 * @return
	 */
	public PensionFund getNit() {
		return nit;
	}

	public void setNit(PensionFund nit) {
		this.nit = nit;
	}

	public Entity getNitEntity() {
		return nitEntity;
	}

	public void setNitEntity(Entity nitEntity) {
		this.nitEntity = nitEntity;
	}
	public double getBenefit() {
		return benefit;
	}
	public void setBenefit(double benefit) {
		this.benefit = benefit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * Metodo Tostring 
	 * que retorna los atrbutos de la clase
	 */
	@Override
	public String toString() {
		return "Agreement [id=" + id + ", nit=" + nit + ", nitEntity="
				+ nitEntity + ", benefit=" + benefit + "]";
	}

}

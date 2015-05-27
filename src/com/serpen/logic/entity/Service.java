package com.serpen.logic.entity;

public class Service {

	/**
	 * indica el id de servicio
	 */
	private int id;
	/**
	 * nombre del servicio
	 */
	private String name;
	/**
	 * costo del servicio
	 */
	private double cost;
	
	/**
	 * 
	 * @param id
	 * @param name nombre
	 * @param cost costo
	 */
	public Service(int id , String name, double cost){
		this.id = id; 
		this.name = name;
		this.cost = cost;
		
	}

	/**
	 * constructor de la clase service
	 */
	public Service (){
		
	}
	/**
	 * Getter y Setter de la clase service
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * toString de la clase service
	 */
	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}
	
	
}

package com.serpen.logic.entity;
/**
 * Clase sericio
 * @author Diana Milena Gonzalez Prieto
 * @author Edgar Antonio Meneses Cadena
 * @author Daniela Alezandra Blanco Albarracin
 * @author Eliana Carolina Ayala Sosa
 *
 *
 */
public class Service {

	private int id;
	private String name;
	private double cost;
	
	public Service() {
		
	}

	public Service(int id , String name, int cost){
		this.id = id; 
		this.name = name;
		this.cost = cost;
		
	}

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
	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}
	
	
}

package com.serpen.logic.entity;
/**
 * clase servicio fondo
 * @author Diana Milena Gonzalez Prieto
 * @author Edgar Antonio Meneses Cadena
 * @author Daniela Alezandra Blanco Albarracin
 * @author Eliana Carolina Ayala Sosa
 */
public class ServiceFund {
	
	private int id;
	private String name;
	private double value;
	private String description;
	private double discount;
	private double interest;
	private String information;
	private String duration; 
	private Entity entity;
	
	public ServiceFund(){
		
	}
	
    public ServiceFund(int id , String name , double value , String description , double discount , double interest, String information, String duration, Entity entity){
		this.id =id;
		this.name = name;
		this.value = value;
		this.description = description;
		this.discount = discount; 
		this.interest = interest;
		this.information = information;
		this.duration =  duration;
		this.entity = entity;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}



	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return "ServiceFund [id=" + id + ", name=" + name + ", value=" + value
				+ ", description=" + description + ", discount=" + discount
				+ ", interest=" + interest + ", information=" + information
				+ ", duration=" + duration + ", entity=" + entity + "]";
	}
	
    
	
	
	
	
	

}

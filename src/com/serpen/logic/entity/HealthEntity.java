package com.serpen.logic.entity;

public class HealthEntity {

	/**
	 * nit del centro de salud
	 */
	 private String nit;
	 /**
	  * nombre del centro de salud
	  */
	 private String name;
	 /**
	  * dirrecion del centro de salud
	  */
	 private String address;
	 /**
	  * telefono del centro de salud
	  */
	 private String phone;
	 /**
	  * catalogo que tiene el centro de salud
	  */
	 private String catalog;
	 
	 /**
	  * 
	  * @param nit nit 
	  * @param name nombre
	  * @param address dirrecion 
	  * @param phone telefono
	  * @param catalog que ofrece en centro de salud
	  */
	 public HealthEntity(String nit , String name, String address , String  phone, String catalog){
		 this.nit = nit;
		 this.name = name;
		 this.address = address;
		 this.phone = phone;
		 this.catalog = catalog;
	 }
	 
	
	/**
	 * constructor de la clase HealthEntity
	 */
	
	 public HealthEntity(){
		 
	 }

    /**
     * Getter y Setter de la clase HealthEntity 
     */
	public String getNit() {
		return nit;
	}


	public void setNit(String nit) {
		this.nit = nit;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCatalog() {
		return catalog;
	}


	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

    /**
     * toString de la clase HealthEntity 
     */
	@Override
	public String toString() {
		return "HealthEntity [nit=" + nit + ", name=" + name + ", address="
				+ address + ", phone=" + phone + ", catalog=" + catalog + "]";
	}
	 
	 
}

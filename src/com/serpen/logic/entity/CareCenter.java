package com.serpen.logic.entity;

public class CareCenter {
	
	/**
	 * indica el nit del centro de servicio 
	 */
	private String nit;
	/**
	 * nombre del centro de servicio
	 */
	private String name;
	/**
	 * dirrecion del centro de servicio
	 */
	private String address;
	/**
	 * Telefono del centro de servicio
	 */
	private String phone;
	
	/**
	 * 
	 * @param nit del centro de servicio
	 * @param name nombre del centro de servicio
	 * @param address dirrecion del centro de serivio
	 * @param phone telefono del centro de servicio
	 */
	public CareCenter(String nit , String name, String address , String  phone){
	 this.nit = nit;
	 this.name = name;
	 this.address = address;
	 this.phone = phone;
	 
	 }
	
	/**
	 * constructor de la clase CareCenter
	 */
	public CareCenter(){
		
	}
 /**
  * Getter y Setter de la clase careCenter 
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

/**
 * toString de la clase centro de servicio
 */
@Override
public String toString() {
	return "CareCenter [nit=" + nit + ", name=" + name + ", address=" + address
			+ ", phone=" + phone + "]";
}
 
 


}

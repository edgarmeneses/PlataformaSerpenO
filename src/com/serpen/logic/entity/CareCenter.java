package com.serpen.logic.entity;
/**
 * Clase centro de Atencion 
 * @author Diana Milena Gonzalez Prieto
 * @author Edgar Antonio Meneses Cadena
 * @author Daniela Alezandra Blanco Albarracin
 * @author Eliana Carolina Ayala Sosa
 *
 */
public class CareCenter {

	private String nit;
	private String name;
	private String address;
	private String phone;


	public CareCenter() {

	}

	public CareCenter(String nit , String name, String address , String phone){
		this.nit = nit;
		this.name = name;
		this.address = address;
		this.phone = phone;

	}

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

	@Override
	public String toString() {
		return "CareCenter [nit=" + nit + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + "]";
	}
}

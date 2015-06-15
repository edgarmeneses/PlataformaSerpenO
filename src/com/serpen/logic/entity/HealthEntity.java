package com.serpen.logic.entity;
/**
 * Clase Entidad de salud
 * @author Diana Milena Gonzalez Prieto
 * @author Edgar Antonio Meneses Cadena
 * @author Daniela Alezandra Blanco Albarracin
 * @author Eliana Carolina Ayala Sosa
 *
 *
 */
public class HealthEntity {

	 private String nit;
	 private String name;
	 private String address;
	 private String phone;
	 private Catalog catalog;
	 
	 
	 public HealthEntity() {
		super();
	}
	public HealthEntity(String nit , String name, String address , String  phone, Catalog catalog){
		 this.nit = nit;
		 this.name = name;
		 this.address = address;
		 this.phone = phone;
		 this.catalog = catalog;
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
	public Catalog getCatalog() {
		return catalog;
	}
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public String toString() {
		return "HealthEntity [nit=" + nit + ", name=" + name + ", address="
				+ address + ", phone=" + phone + ", catalog=" + catalog + "]";
	}
	 
	 
}

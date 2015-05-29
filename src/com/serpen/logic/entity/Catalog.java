package com.serpen.logic.entity;
/**
 * 
 * Clase Catalogo
 * 
 * @author Diana Milena Gonzalez Prieto
 * @author Edgar Antonio Meneses Cadena
 * @author Daniela Alezandra Blanco Albarracin
 * @author Eliana Carolina Ayala Sosa
 *
 */
public class Catalog {

	/**
	 * indica el id que tiene calogo
	 */
	private int id ; 
	/**
	 * descuento que tiene el catalogo
	 */
	private double discount;
	/**
	 * servicio que se ofrece en el catalogo 
	 */
	private Service service; 
	/**
	 * centro de antencion
	 */
	private CareCenter carecenter;

	public Catalog() {
		
	}

	/**
	 * 
	 * @param id 
	 * @param discount Descuento 
	 * @param service  Servicion
	 * @param careCenter Centro de antencion
	 */
	public Catalog(int id , int discount , Service service , CareCenter careCenter){
		this.id = id;
		this.discount = discount;
		this.service = service;
		this.carecenter = careCenter;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public CareCenter getCarecenter() {
		return carecenter;
	}

	public void setCarecenter(CareCenter carecenter) {
		this.carecenter = carecenter;
	}

	@Override
	public String toString() {
		return "Catalog [id=" + id + ", discount=" + discount + ", service="
				+ service + ", carecenter=" + carecenter + "]";
	}



}

package com.serpen.logic.entity;

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
	private int service; 
	/**
	 * centro de antencion
	 */
	private String carecenter;
	
	/**
	 * 
	 * @param id 
	 * @param discount Descuento 
	 * @param service  Servicion
	 * @param careCenter Centro de antencion
	 */
	public Catalog(int id , double discount , int service , String careCenter){
	this.id = id;
	this.discount = discount;
	this.service = service;
	this.carecenter = careCenter;
	}
    /**
     * constructor de la clase catalog 
     */
	public Catalog(){
		
	}
	/**
 	 * Getters y Setters de la clase catalog
	 */
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public double  getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getService() {
		return service;
	}

	public void setService(int service) {
		this.service = service;
	}

	public String getCarecenter() {
		return carecenter;
	}

	public void setCarecenter(String carecenter) {
		this.carecenter = carecenter;
	}

	/**
	 * toString de la clase catalog
	 */
	@Override
	public String toString() {
		return "Catalog [id=" + id + ", discount=" + discount + ", service="
				+ service + ", carecenter=" + carecenter + "]";
	}
	
	

}

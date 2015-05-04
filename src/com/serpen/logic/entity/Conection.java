package com.serpen.logic.entity;
/**
 * UNiversidad Pedagogica y Tecnologica de Colombia
 * @author Eliana Ayala
 * 		   Daniela Blanco
 * 		   Diana Gonzalez
 * 	       Edgar Meneces
 *Clase  que se encarga de hacer la coneccion con las bases de datos de las entidades
 */
public class Conection {
	
	/**
	 * Atributos de la clase de Conection 
	 */
	private int id;
	private String url;
	private int port;
	private String name_Bd;
	private Entity nit;
	/**
	 * Constructor de la clase Conection 
	 */
	public Conection() {
	
	}
	/**
	 * Constrouctor que pide por parametro los atributos de esta clase
	 * @param id
	 * @param url
	 * @param port
	 * @param name_Bd
	 * @param nit
	 */
	public Conection(int id, String url, int port, String name_Bd) {
		
		this.id = id;
		this.url = url;
		this.port = port;
		this.name_Bd = name_Bd;
		nit = new Entity();
	}
	/**
	 * Getters y Setters 
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getName_Bd() {
		return name_Bd;
	}
	public void setName_Bd(String name_Bd) {
		this.name_Bd = name_Bd;
	}

	public Entity getNit() {
		return nit;
	}
	public void setNit(Entity nit) {
		this.nit = nit;
	}
	/**
	 * To String de la clase Conection  que retorna los datos 
	 */
	@Override
	public String toString() {
		return "conection [id=" + id + ", url=" + url + ", port=" + port
				+ ", name_Bd=" + name_Bd + ", nit=" + nit + "]";
	}

}

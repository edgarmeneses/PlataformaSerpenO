package com.serpen.logic.entity;
/**
 * Case histrial usuario
 * @author Diana Milena Gonzalez Prieto
 * @author Edgar Antonio Meneses Cadena
 * @author Daniela Alezandra Blanco Albarracin
 * @author Eliana Carolina Ayala Sosa
 *
 */
public class UserHistory {
	private int id;
	private int nickname;
	private char estado;
	private String  rol;
	private String name;
	private String lastName;
	private String PensionFund;
	private String healthEntity;
	private String business;
	private double salary;

	public static final char TIPO_ESTADO_INACTIVO= 'I'; 

	public UserHistory() {

	}
	public UserHistory(int id, int nickname, char estado, String rol) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.estado = estado;
		this.rol = rol;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNickname() {
		return nickname;
	}
	public void setNickname(int nickname) {
		this.nickname = nickname;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPensionFund() {
		return PensionFund;
	}
	public void setPensionFund(String pensionFund) {
		PensionFund = pensionFund;
	}
	public String getHealthEntity() {
		return healthEntity;
	}
	public void setHealthEntity(String healthEntity) {
		this.healthEntity = healthEntity;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "UserHistory [id=" + id + ", nickname=" + nickname + ", estado="
				+ estado + ", rol=" + rol + ", name=" + name + ", lastName="
				+ lastName + ", PensionFund=" + PensionFund + ", healthEntity="
				+ healthEntity + ", business=" + business + ", salary="
				+ salary + "]";
	}
}

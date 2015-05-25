package com.serpen.logic.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * clase entidad financiera
 * 
 * @author Diana Milena Gonzalez Prieto
 * @author Edgar Antonio Meneses Cadena
 * @author Daniela Alezandra Blanco Albarracin
 * @author Eliana Carolina Ayala Sosa
 *
 */
public class FinancialEntity {
	
	private String nit;
	private String name;
	private String address;
	private String numberPhone;
	private Set<Account> accounts;
	private Set<Credit> credits;
	
	public FinancialEntity() {
		accounts = new HashSet<Account>();
		credits =new HashSet<Credit>();
	}
	
	public FinancialEntity(String nit, String name, String address,
			String numberPhone) {
		super();
		this.nit = nit;
		this.name = name;
		this.address = address;
		this.numberPhone = numberPhone;
		accounts = new HashSet<Account>();
		credits = new HashSet<Credit>();
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

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Credit> getCredits() {
		return credits;
	}

	public void setCredits(Set<Credit> credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "FinancialEntity [nit=" + nit + ", name=" + name + ", address="
				+ address + ", numberPhone=" + numberPhone + "]";
	}
	
	
	
	 
	
	
	
	

}

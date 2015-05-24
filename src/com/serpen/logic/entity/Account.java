package com.serpen.logic.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * clase cuenta
 * 
 * @author Diana Milena Gonzalez Prieto
 * @author Edgar Antonio Meneses Cadena
 * @author Daniela Alezandra Blanco Albarracin
 * @author Eliana Carolina Ayala Sosa
 *
 */
public class Account {
	
	private int number;
	private String tipoCuenta;
	private User user;
	private FinancialEntity financialEntity;
	private Set<TransactionP> transactions;
	public static final String CERTIFICA_DE_DEPOSITO="CDT";
	public static final String CUENTA_CORRIENTE="COR";
	public static final String CUENTA_DE_AHORROS="AHO";
	public static final String CUENTA_DE_CARTERA_COLECTIVA="COL";
	
	public Account() {
		transactions =new HashSet<TransactionP>();
	}

	public Account(int number, String tipoCuenta, User user,
			FinancialEntity financialEntity) {
		super();
		this.number = number;
		this.tipoCuenta = tipoCuenta;
		this.user = user;
		this.financialEntity = financialEntity;
		transactions = new HashSet<TransactionP>();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FinancialEntity getFinancialEntity() {
		return financialEntity;
	}

	public void setFinancialEntity(FinancialEntity financialEntity) {
		this.financialEntity = financialEntity;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", tipoCuenta=" + tipoCuenta
				+ ", user=" + user + ", financialEntity=" + financialEntity
				+ "]";
	}
}

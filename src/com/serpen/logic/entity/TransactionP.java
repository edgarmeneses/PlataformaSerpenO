package com.serpen.logic.entity;

import java.util.Date;
/**
 * Clase Trasnaccion
 * @author Diana Milena Gonzalez Prieto
 * @author Edgar Antonio Meneses Cadena
 * @author Daniela Alezandra Blanco Albarracin
 * @author Eliana Carolina Ayala Sosa
 *
 *
 */
public class TransactionP {

	private int id;
	private char transactionType;
	private double amount;
	private Date date;
	private Account account;
	public static final char RETREAT='R';
	public static final char ENTRY='I';
	
	public TransactionP() {
		
	}

	public TransactionP(int id, char trnsactionType, double amount, Date date,
			Account account) {
		
		this.id = id;
		this.transactionType = trnsactionType;
		this.amount = amount;
		this.date = date;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public char getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(char transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "TransactionP [id=" + id + ", transactionType="
				+ transactionType + ", amount=" + amount + ", date=" + date
				+ ", account=" + account + "]";
	}
	
	
}

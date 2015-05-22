package com.serpen.logic.entity;

import java.util.Date;

public class Transaction {

	private int id;
	private char transactionType;
	private double amount;
	private Date date;
	private Account account;
	public static final char RETREAT='R';
	public static final char ENTRY='I';
	
	public Transaction() {
		
	}

	public Transaction(int id, char trnsactionType, double amount, Date date,
			Account account) {
		super();
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

	public char getTrnsactionType() {
		return transactionType;
	}

	public void setTrnsactionType(char trnsactionType) {
		this.transactionType = trnsactionType;
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

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", trnsactionType=" + transactionType
				+ ", amount=" + amount + ", date=" + date + ", account="
				+ account + "]";
	}
}

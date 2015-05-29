package com.serpen.logic.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase credito
 * @author Diana Milena Gonzalez Prieto
 * @author Edgar Antonio Meneses Cadena
 * @author Daniela Alezandra Blanco Albarracin
 * @author Eliana Carolina Ayala Sosa
 *
 */
public class Credit {
	
	private int id;
	private double amount;
	private int share;
	private User user;
	private FinancialEntity financialEntity;
	private Set<PaymentPlan> paymentPlans;
	
	public Credit() {
		paymentPlans = new HashSet<PaymentPlan>();
	}

	public Credit(int id, double amount, int share, User user,
			FinancialEntity financialEntity) {
		
		this.id = id;
		this.amount = amount;
		this.share = share;
		this.user = user;
		this.financialEntity = financialEntity;
		this.paymentPlans = new HashSet<PaymentPlan>();
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

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
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

	public Set<PaymentPlan> getPaymentPlans() {
		return paymentPlans;
	}

	public void setPaymentPlans(Set<PaymentPlan> paymentPlans) {
		this.paymentPlans = paymentPlans;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", amount=" + amount + ", share=" + share
				+ ", user=" + user + ", financialEntity=" + financialEntity
				+ "]";
	}

}

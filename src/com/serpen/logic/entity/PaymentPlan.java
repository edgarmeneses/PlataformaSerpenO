package com.serpen.logic.entity;

import java.util.Date;

/**
 * plan de pago
 * @author Edgar Meneses
 *
 */
public class PaymentPlan {
	
	private int quotaNumber;
	private Date paymntDate;
	private double amount;
	private Credit credit;
	
	public PaymentPlan() {
		
	}

	public PaymentPlan(int quotaNumber, Date paymntDate, double amount,
			Credit credit) {
		super();
		this.quotaNumber = quotaNumber;
		this.paymntDate = paymntDate;
		this.amount = amount;
		this.credit = credit;
	}

	public int getQuotaNumber() {
		return quotaNumber;
	}

	public void setQuotaNumber(int quotaNumber) {
		this.quotaNumber = quotaNumber;
	}

	public Date getPaymntDate() {
		return paymntDate;
	}

	public void setPaymntDate(Date paymntDate) {
		this.paymntDate = paymntDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "PaymentPlan [quotaNumber=" + quotaNumber + ", paymntDate="
				+ paymntDate + ", amount=" + amount + ", credit=" + credit
				+ "]";
	}
}

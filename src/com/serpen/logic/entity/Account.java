package com.serpen.logic.entity;

import java.util.HashSet;
import java.util.List;
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
	private String accountType;
	private User user;
	private FinancialEntity financialEntity;
	private Set<TransactionP> transactions;
//	private TransactionP transactionP;
	public static final String CERTIFICADO_DE_DEPOSITO="CDT";
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
		this.accountType = tipoCuenta;
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

	public Set<TransactionP> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<TransactionP> transactions) {
		this.transactions = transactions;
	}

	public String getAccountType() {
		switch (this.accountType) {
		case "CDT":			
			return "CDT";
		case "COR":			
			return "CUENTA CORRIENTE";
		case "AHO":			
			return "CUENTA AHORRO";
		case "COL":
			return "CUENTA DE CARTERA COLECTIVA";
		default:
			break;
		}
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
   public double saldoCuenta(List<TransactionP> listTransaction){
		
	    double ingreso=0;
	    double retiro=0;
	    double saldo=0;
	    
	    for (TransactionP transactionP : listTransaction) {
	    	if (transactionP.getTransactionType() == "Ingreso") {
	    		ingreso= ingreso+transactionP.getAmount();
	    	}else {
				retiro=retiro+transactionP.getAmount();
			}
		}
	    saldo=ingreso-retiro;
		return saldo; 
	}
	

	@Override
	public String toString() {
		return "Account [number=" + number + ", tipoCuenta=" + accountType
				+ ", user=" + user + ", financialEntity=" + financialEntity
				+ "]";
	}
}

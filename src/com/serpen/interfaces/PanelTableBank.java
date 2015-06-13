package com.serpen.interfaces;

import com.mysql.jdbc.util.Base64Decoder.IntWrapper;
import com.serpen.logic.entity.Account;
import com.serpen.logic.entity.TransactionP;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlAccount;
import com.serpen.persistence.control.ControlTransactionP;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;

import java.util.List;

import org.hibernate.Session;

public class PanelTableBank extends Panel {

	private Table table; 
	private Panel pnlTable;
	private Label lblTitle;
	private Panel pnlTitle;
	
	private Panel pnlSearch;
	private Label lblSearch;
	private TextField txtSearch;
	private Button btnSearch;
	
	private ControlAccount controlAccount;
	
	private Navigator navigator;
	
	private String id; 
	
	private TransactionP transactionP;
	private ControlTransactionP controlTransactionP;
	private Account account;
	private Session session;

	private int numberAccount;
	private PanelButtonTransaction buttonTransaction;
	public PanelTableBank(Navigator navigator){
		
		this.navigator =  navigator;
		 session = HibernateUtil.getSessionFactory().openSession();
		 this.account = new Account();
		
		 this.buttonTransaction = new PanelButtonTransaction(navigator, this, account);
		
		controlAccount = new ControlAccount(session);
		
		FormLayout formLayout = new FormLayout();
		formLayout.setVisible(true);
		
		FormLayout formTable = new FormLayout();
		formTable.setVisible(true);
		
		FormLayout formTitle = new FormLayout();
		formTitle.setVisible(true);
		
		FormLayout formSearch = new FormLayout();
		formSearch.setVisible(true);
		
		HorizontalLayout horizontlTitle = new  HorizontalLayout();
		horizontlTitle.setVisible(true);
		
		HorizontalLayout horizontalSearch = new HorizontalLayout();
		horizontalSearch.setVisible(true);
		
		pnlTitle = new Panel();
		pnlTitle.setSizeFull();
		pnlTitle.setWidth("1000");
		pnlTitle.setHeight("80");
		
		pnlSearch = new Panel();
		pnlSearch.setSizeFull();
		pnlSearch.setWidth("1000");
		pnlSearch.setHeight("100");
		
		pnlTable = new Panel();
		pnlTable.setWidth("1000px");
		pnlTable.setHeight("400px");
		pnlTable.setSizeFull();
		pnlTable.setVisible(true);
		
		lblTitle = new Label("Banco de Colombia");		
		lblTitle.setWidth("200px");
		lblTitle.setHeight("50px");
		lblTitle.setVisible(true);
		
		lblSearch = new Label("Tipo de cuenta");
		lblSearch.setWidth("100px");
		lblSearch.setHeight("50px");
		lblSearch.setVisible(true);
		
		txtSearch = new TextField();
		txtSearch.setWidth("150px");
		txtSearch.setHeight("50px");
		txtSearch.setRequired(true);
		txtSearch.setValue("");
		txtSearch.setNullRepresentation("");
		txtSearch.setVisible(true);
		
				
		btnSearch = new Button("Buscar");
		btnSearch.setWidth("150px");
		btnSearch.setHeight("50px");
		btnSearch.setVisible(true);
		 
		btnSearch.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub	
			 fill();
				
			}
		});
	    
		table = new Table();
	    
		table.addContainerProperty("Tipo de cuenta", String.class, null);
		table.addContainerProperty("Numero de cuenta", String.class, null);
		table.addContainerProperty("Estado de Cuenta", String.class, null);
		table.addContainerProperty("Transacciones", PanelButtonTransaction.class, null);
	
	    table.setPageLength(table.size());
		table.setWidth("80%"); 
		table.setHeight("180px");
		table.setFooterVisible(true);
		
		formTable.addComponent(table);
		
		horizontlTitle.addComponent(lblTitle);
		
		horizontalSearch.addComponent(lblSearch);
		horizontalSearch.addComponent(txtSearch);
		horizontalSearch.addComponent(btnSearch);
		
		formSearch.addComponent(horizontalSearch);
		
		formTitle.addComponent(horizontlTitle);
		
		this.pnlTable.setContent(formTable);
		this.pnlTitle.setContent(formTitle);
		this.pnlSearch.setContent(formSearch);
		
		formLayout.addComponent(pnlTitle);
		formLayout.addComponent(pnlSearch);
		formLayout.addComponent(pnlTable);
		
		
		setContent(formLayout);
			
		
		
	}
	
	public Object[] fillRow (Account account,List<TransactionP> listTransaction){
		id = String.valueOf(account.getNumber());
		return new Object[] { account.getAccountType() ,String.valueOf(account.getNumber()),String.valueOf(account.saldoCuenta(listTransaction)), new PanelButtonTransaction(navigator, this, account)};
		
	}
	
	public void fill(){
		try {
	
		List<Account> account = controlAccount.list(txtSearch.getValue());	
		ControlTransactionP controlTransactionP = new ControlTransactionP(session);
		table.removeAllItems();
		
		for (int i = 0; i < account.size(); i++) {
			//System.out.println("listaaaa"+account.get(i));
			//fillRow(account.get(i), controlTransactionP.list(account.get(i).getNumber()));
			table.addItem(fillRow(account.get(i), controlTransactionP.list(account.get(i).getNumber())),i);
		System.out.println(account.get(i).getNumber());	
			int numberAccount  = account.get(i).getNumber();
		} 
		}  catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		}
		
		
	}

	public PanelButtonTransaction getButtonTransaction() {
		return buttonTransaction;
	}

	public void setButtonTransaction(PanelButtonTransaction buttonTransaction) {
		this.buttonTransaction = buttonTransaction;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
		
}


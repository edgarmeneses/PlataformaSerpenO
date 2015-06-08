package com.serpen.interfaces;

import com.mysql.jdbc.util.Base64Decoder.IntWrapper;
import com.serpen.logic.entity.Account;
import com.serpen.logic.entity.TransactionP;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlAccount;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

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
	
	private Link lbllink;
	private Navigator navigator;
	
	private TransactionP transactionP;
	

	public PanelTableBank(Navigator navigator){
		
		this.navigator =  navigator;
		Session  session = HibernateUtil.getSessionFactory().openSession();
		
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
		table.addContainerProperty("Estado de cuenta", Integer.class, 0);
		table.addContainerProperty("Numero de cuenta", Integer.class, 0);
		table.addContainerProperty("Transacciones", Link.class, null);

//		lbllink = new Link("Transacciones" , new ExternalResource("#!"+ WindowBank.NAMEWINDOWSBANK));
//		table.addItem(new Object[]{" ", " " , " ", new PanelLinkTransaction()}, 2);
//	    table.addItem(new Object[] { " " ," " , " ", " "},3);
//		
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
	
	public Object[] fillRow (Account account){
		return new Object[] { account.getAccountType(), account.getNumber() ,account.getNumber() ,this.lbllink};
	
	}
	
	public void fill(){
		try {
			System.out.println(txtSearch.getValue());
//		List<Account> account  = controlAccount.list(txtSearch.getValue());
			
		List<Account> account = controlAccount.list(txtSearch.getValue());	
		
		for (int i = 0; i < account.size(); i++) {
			System.out.println("Lista" + fillRow(account.get(i)));
				
		}
		table.removeAllItems();
		for (int i = 0; i < account.size(); i++) {
			table.addItem(fillRow(account.get(i)),i);
			
		} 
		}  catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		}
		
	}
		
}


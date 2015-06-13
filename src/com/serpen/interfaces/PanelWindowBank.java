package com.serpen.interfaces;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Session;

import com.google.gwt.dev.shell.BrowserChannel.Value.ValueType;
import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.TransactionP;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlTransactionP;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class PanelWindowBank extends Panel{

	private Panel pnlTitle;
	private Label lblTitle;
	private Panel pnlSearch;
	private Label lblSearch;
	private TextField txtSearch; 
	private Button btnSearch;
	private Panel pnlTable;
	private Table table;
	private Panel pnlButton;
	private Button btnCancel;
	
	private ControlTransactionP transactionP;
	private PanelTableBank panelTableBank;
	private Navigator navigator;
	
	private PanelButtonTransaction buttonTransaction;
	
	public PanelWindowBank (){
		
		Session session= HibernateUtil.getSessionFactory().openSession();
		
		transactionP = new ControlTransactionP(session);
		this.panelTableBank = new PanelTableBank(navigator);
		FormLayout formGeneral = new FormLayout();
		formGeneral.setVisible(true);
		
		FormLayout formTitle = new FormLayout();
		formTitle.setVisible(true);
		
		FormLayout formSearch = new FormLayout();
		formSearch.setVisible(true);
		
		FormLayout formTable = new FormLayout();
		formTable.setVisible(true);
		
		FormLayout formButton = new FormLayout();
		formButton.setVisible(true);
		
		HorizontalLayout horizontalTitle = new HorizontalLayout();
		horizontalTitle.setVisible(true);
		
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
		
		pnlButton = new Panel();
		pnlButton.setWidth("1000");
		pnlButton.setHeight("80");
		pnlButton.setSizeFull();
		pnlButton.setVisible(true);
		
		lblTitle = new Label("Transacciones");
		lblTitle.setWidth("200px");
		lblTitle.setHeight("50px");
		lblTitle.setVisible(true);
		
		lblSearch = new Label("Fecha");
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
		
        table.addContainerProperty("Numero de transaccion", String.class, null);
		table.addContainerProperty("Fecha", String.class, null);
		table.addContainerProperty("Tipo transaccion", String.class, null);
		table.addContainerProperty("Monto", String.class, null);

		table.setPageLength(table.size());
		table.setWidth("80%"); 
		table.setHeight("180px");
		table.setFooterVisible(true);
		
		btnCancel = new Button("Cancelar");
		btnCancel.setWidth("150px");
		btnCancel.setHeight("50px");
		btnCancel.setVisible(true);
		
		formTable.addComponent(table);
		
		horizontalTitle.addComponent(lblTitle);
		
		horizontalSearch.addComponent(lblSearch);
		horizontalSearch.addComponent(txtSearch);
		horizontalSearch.addComponent(btnSearch);
		
		formSearch.addComponent(horizontalSearch);
		formTitle.addComponent(horizontalTitle);
		
		formButton.addComponent(btnCancel);
		
		this.pnlTitle.setContent(formTitle);
		this.pnlSearch.setContent(formSearch);
		this.pnlTable.setContent(formTable);
		this.pnlButton.setContent(formButton);

		formGeneral.addComponent(pnlTitle);
		formGeneral.addComponent(pnlSearch);
		formGeneral.addComponent(pnlTable);
		formGeneral.addComponent(pnlButton);
		
		setContent(formGeneral);
		
		
		
		
	    
	}
	
	public  Object[] fillRow(TransactionP transactionP){
		return new Object[] { String.valueOf(transactionP.getId()),String.valueOf(transactionP.getDate()) , String.valueOf(transactionP.getTransactionType()), String.valueOf(transactionP.getAmount()) };
		}
	
	public void  fill (){
			
		List<TransactionP> transaction;
		try {
			transaction = transactionP.list(Integer.valueOf(panelTableBank.getId()));
			for (int i = 0; i < transaction.size(); i++) {
				System.out.println("lista" + fillRow(transaction.get(i)));
			}
//			
			table.removeAllItems();
			for (int i = 0; i < transaction.size(); i++) {
				table.addItem(fillRow(transaction.get(i)),i);
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
     
	
	}
}

package com.serpen.interfaces;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;

public class PanelTableBank extends Panel {

	private Table table; 
	private Panel pnlTable;
	private Label lblTitle;
	private Panel pnlTitle;
	
	
	public PanelTableBank(){
		
		FormLayout formLayout = new FormLayout();
		formLayout.setVisible(true);
		
		FormLayout formTable = new FormLayout();
		formTable.setVisible(true);
		
		FormLayout formTitle = new FormLayout();
		formTitle.setVisible(true);
		
		HorizontalLayout horizontlTitle = new  HorizontalLayout();
		horizontlTitle.setVisible(true);
		
		pnlTitle = new Panel();
		pnlTitle.setSizeFull();
		pnlTitle.setWidth("1000");
		pnlTitle.setHeight("80");
		
		
		pnlTable = new Panel();
		pnlTable.setWidth("1000px");
		pnlTable.setHeight("400px");
		pnlTable.setSizeFull();
		pnlTable.setVisible(true);
		
		lblTitle = new Label("Banco de Colombia");		
		lblTitle.setWidth("200px");
		lblTitle.setHeight("50px");
		lblTitle.setVisible(true);
		
	    table = new Table();
	    
	    table.addContainerProperty("Tipo de cuenta", String.class, null);
		table.addContainerProperty("Estado de cuenta", String.class, null);
		table.addContainerProperty("Numero de cuenta", String.class, null);
		table.addContainerProperty("Transacciones", String.class, null);

		table.addItem(new Object[]{" ", " " , " ", " "}, 2);
	    table.addItem(new Object[] { " " ," " , " ", " "},3);
		
	    table.setPageLength(table.size());
		table.setWidth("80%"); 
		table.setHeight("180px");
		table.setFooterVisible(true);
		
		formTable.addComponent(table);
		
		horizontlTitle.addComponent(lblTitle);
		
		formTitle.addComponent(horizontlTitle);
		
		this.pnlTable.setContent(formTable);
		this.pnlTitle.setContent(formTitle);
		
		formLayout.addComponent(pnlTitle);
		formLayout.addComponent(pnlTable);
		
		
		setContent(formLayout);
			
		
		
	}
}

package com.serpen.interfaces;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;

public class PanelTableBank extends Panel {

	private Table table; 
	private Panel pnlTable;
	private Label lblTitle;
	private Panel pnlTitle;
	
	private Panel pnlSearch;
	private Label lblSearch;
	private TextField txtSearch;
	private Button btnSearch;
	

	public PanelTableBank(){
		
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
}

package com.serpen.interfaces;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;

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
	
	public PanelWindowBank (){
		
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

        table = new Table();
		
		table.addContainerProperty("Fecha", String.class, null);
		table.addContainerProperty("Descripción", String.class, null);
		table.addContainerProperty("Ingreso", String.class, null);
		table.addContainerProperty("Egreso", String.class, null);
		table.addContainerProperty("Saldo", String.class, null);
		
	    table.addItem(new Object[]{" ", " " , " ", " "}, 2);
	    table.addItem(new Object[] { " " ," " , " ", " "},3);
		
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
	
	
	
}

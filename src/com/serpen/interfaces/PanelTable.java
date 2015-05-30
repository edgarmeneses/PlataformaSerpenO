package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;

public class PanelTable extends Panel{
	
	private Table table;
	private Panel panelTable;
	private Navigator navigator;
	private Label lblService; 
	private TextField txtService;
	private Button btnSearch;
	private Panel pnlSearch; 
	private Panel pnlTitle;
	private Label lblTitle;
	
	public PanelTable(Navigator navigator){
		
		this.navigator = navigator;
		
		FormLayout layoutGeneral  = new FormLayout();
		layoutGeneral.setVisible(true);
		
		FormLayout formTable = new FormLayout();
		formTable.setVisible(true);
		
		FormLayout formSearch = new FormLayout();
		formSearch.setVisible(true);
		
		FormLayout formTitle = new FormLayout();
		formTitle.setVisible(true);
		
		HorizontalLayout horizontalLayoutSearch = new HorizontalLayout();
		horizontalLayoutSearch.setVisible(true);
		
		HorizontalLayout horizontalLayoutTitle = new HorizontalLayout();
		horizontalLayoutSearch.setVisible(true);
		pnlTitle =new Panel();
		pnlTitle.setSizeFull();
		pnlTitle.setWidth("1000");
		pnlTitle.setHeight("80");
		
		pnlSearch = new Panel();
		pnlSearch.setSizeFull();
		pnlSearch.setWidth("1000");
		pnlSearch.setHeight("100");
//		pnlSearch.setVisible(true);
				
		panelTable = new Panel();
		panelTable.setWidth("1000px");
		panelTable.setHeight("400px");
		panelTable.setSizeFull();
		panelTable.setVisible(true);
		
		lblTitle = new Label("Lista de servicios");		
		lblTitle.setWidth("200px");
		lblTitle.setHeight("50px");
		lblTitle.setVisible(true);
		
		lblService = new Label("Servicio");
		lblService.setWidth("100px");
		lblService.setHeight("50px");
		lblService.setVisible(true);
		
		txtService = new TextField();
		txtService.setWidth("150px");
		txtService.setHeight("50px");
		
		
		btnSearch= new  Button("Buscar");
		btnSearch.setWidth("150px");
		btnSearch.setHeight("50px");
		btnSearch.setVisible(true);
		table = new Table();
		
		table.addContainerProperty("Servicio", String.class, null);
		table.addContainerProperty("Descripcion", String.class, null);
		table.addContainerProperty("Informacion", String.class, null);
		table.addContainerProperty("Direccion", String.class, null);
		table.addContainerProperty("Telefono", String.class, null);
		
	    table.addItem(new Object[]{" ", " " , " ", " "}, 2);
	    table.addItem(new Object[] { " " ," " , " ", " "},3);
	    
		table.setPageLength(table.size());
		table.setWidth("80%"); 
		table.setHeight("180px");
		table.setFooterVisible(true);
		
		formTable.addComponent(table);
		
		horizontalLayoutSearch.addComponent(lblService);
		horizontalLayoutSearch.addComponent(txtService);
		horizontalLayoutSearch.addComponent(btnSearch);
		
		horizontalLayoutTitle.addComponent(lblTitle);
		
		formSearch.addComponent(horizontalLayoutSearch);
		formTitle.addComponent(horizontalLayoutTitle);
		
		this.panelTable.setContent(formTable);
		this.pnlSearch.setContent(formSearch);
		this.pnlTitle.setContent(formTitle);
		
		layoutGeneral.addComponent(pnlTitle);
		layoutGeneral.addComponent(pnlSearch);
				layoutGeneral.addComponent(panelTable);
		
		
		setContent(layoutGeneral);
	}

}

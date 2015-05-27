package com.serpen.interfaces;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class PanelTableService extends Panel{

	private Table table;
	private Panel pnlTable;

		
	public PanelTableService(){
		
		FormLayout formLayout = new FormLayout();
		formLayout.setVisible(true);
					
		pnlTable = new Panel();
		pnlTable.setSizeFull();
		pnlTable.setWidth("1000px");
		pnlTable.setHeight("300px");
		
		table = new Table();
		
		table.addContainerProperty("Servicios", String.class, null);
		table.addContainerProperty("Descripcion", String.class, null);
		table.addContainerProperty("Informacion", String.class, null);
		table.addContainerProperty("Direccion", String.class, null);
		table.addContainerProperty("Telefono", String.class, null);
		
		table.setPageLength(table.size());
		table.setWidth("80%"); 
		table.setHeight("170px");
		table.setFooterVisible(true);
		
		
		formLayout.addComponent(table);
		this.pnlTable.setContent(formLayout);
		
		
		setContent(formLayout);
		
		this.setSizeFull();
		
		
	}
}

package com.serpen.interfaces;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class PanelTourism extends Panel {
	
	private Panel pnlImage;
	private Image imagen;
	private Panel pnlTable;
	private Table table;
	private Panel pnlDescription;
	private Label lblName;
	private Label lblAdress;
	private Label lblTelephon;
	
	public PanelTourism(){
		
		
		FormLayout layoutGeneral = new FormLayout();
		layoutGeneral.setVisible(true);
		
		FormLayout formImage = new FormLayout();
		formImage.setVisible(true);
		
		FormLayout formTable = new FormLayout();
		formTable.setVisible(true);
		
		FormLayout formDescription = new FormLayout();
		formDescription.setVisible(true);
		
		VerticalLayout horizontalLayout = new VerticalLayout();
		
		pnlImage = new Panel("Image");
		pnlImage.setSizeFull();
		pnlImage.setWidth("1000px");
		pnlImage.setHeight("600px");
		
		pnlTable = new Panel("Table");
		pnlTable.setSizeFull();
		pnlTable.setWidth("1000px");
		pnlTable.setHeight("400px");
		
		
		imagen = new Image();
		ThemeResource resource = new ThemeResource("../Imagen/mexico.jpg");
		this.imagen = new Image(null,resource);
		this.imagen.setWidth("300px");
		this.imagen.setHeight("200px");
		this.setVisible(true);
		//300  y 200
		
		table = new Table();
		
		table.setPageLength(table.size());
		table.setWidth("80%"); 
		table.setHeight("180px");
		table.setFooterVisible(true);
			
		table.addContainerProperty("Plan", String.class, null);
		table.addContainerProperty("Costo", String.class, null);
		table.addContainerProperty("Duracion", String.class, null);
		table.addContainerProperty("Caracteristica", String.class, null);
		
		table.addItem(new Object[] { " " ," " , " ", " "},2);
		table.addItem(new Object[] { " " ," " , " ", " "},3);
		
		lblName = new Label("Centro vacacional canapro");
		lblName.setVisible(true);
		
		lblAdress = new Label("Ubicado en calle 2 N 15-34");
		lblAdress.setVisible(true);
		
		lblTelephon = new Label("Tel : 7440904");
		lblTelephon.setVisible(true);
		
		
		formImage.addComponent(imagen);
		formTable.addComponent(table);
		
		horizontalLayout.addComponent(lblName);
		horizontalLayout.addComponent(lblAdress);
		horizontalLayout.addComponent(lblTelephon);
		
		formDescription.addComponent(horizontalLayout);
		
		layoutGeneral.addComponent(formImage);
		layoutGeneral.addComponent(formTable);
		layoutGeneral.addComponent(formDescription);
		
		
		setContent(layoutGeneral);
				
		
	}

}

package com.serpen.interfaces;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class PanelOptionTourism extends Panel{
	
	private Image imgTourism;
	private Label lblTourims;
	
	public PanelOptionTourism(){
		
		FormLayout formLayout = new FormLayout();
		formLayout.setVisible(true);
		
		VerticalLayout verticalLayout = new VerticalLayout();
		
		this.imgTourism = new Image("Turismo");
		ThemeResource resource = new ThemeResource("../Imagen/turismo.png");
		this.imgTourism = new Image(null, resource);
		this.imgTourism.setWidth("100px");
		this.imgTourism.setHeight("100px");
		this.setVisible(true);
		
		this.lblTourims = new Label("Turismo");		
		this.lblTourims.setVisible(true);
		
		verticalLayout.addComponent(imgTourism);
		verticalLayout.addComponent(lblTourims);
		
		formLayout.addComponent(verticalLayout);
		setContent(formLayout);
		
		
	}
	
}

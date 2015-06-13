package com.serpen.interfaces;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class PanelOptionBank extends Panel{

	private Image imgEntity;
	private Label lblEntity;
	private Navigator navigator;
	
	public PanelOptionBank(Navigator navigator){
	
		this.navigator = navigator;
		
		FormLayout formLayout = new FormLayout();
		formLayout.setVisible(true);
		
		VerticalLayout verticalLayout = new VerticalLayout();
		
		this.imgEntity = new Image("Entidad salud");
		ThemeResource resource = new ThemeResource("../Imagen/Banco.png");
		this.imgEntity = new Image(null, resource);
		this.imgEntity.setWidth("100px");
		this.imgEntity.setHeight("100px");
		this.setVisible(true);
		
	
		this.lblEntity = new Label("Entidad Banco");
		this.lblEntity.setVisible(true);
		
		verticalLayout.addComponent(imgEntity);
		verticalLayout.addComponent(lblEntity);
		
		formLayout.addComponent(verticalLayout);
		
		setContent(formLayout);
		
	
	}
	
}

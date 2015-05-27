package com.serpen.interfaces;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class PanelOptionHealth extends Panel {
	
	private Image  imgHealth;
	private Image imgReport;
	
	public PanelOptionHealth (){
		
    FormLayout formLayout = new FormLayout();
    formLayout.setVisible(true);
    

	VerticalLayout verticalHealth = new VerticalLayout();
	
	VerticalLayout verticalReport = new VerticalLayout();
    
	this.imgHealth = new Image("Salud");
	ThemeResource resource1 = new ThemeResource("../Imagen/salud.png");
	imgHealth = new Image(null , resource1);
	this.imgHealth.setWidth("100px");
	this.imgHealth.setHeight("100px");
	this.imgHealth.setVisible(true);
	
	this.imgReport = new Image("Certificado");
	ThemeResource resource2 = new ThemeResource("../Imagen/certificado.png");
	imgReport = new Image(null , resource2);
	this.imgReport.setWidth("100px");
	this.imgReport.setHeight("100px");
	this.imgReport.setVisible(true);
	
	verticalHealth.addComponent(imgHealth);
	verticalReport.addComponent(imgReport);
	
	
	formLayout.addComponent(verticalHealth);
	formLayout.addComponent(verticalReport);
	
		
	setContent(formLayout);
	
	
	}

}

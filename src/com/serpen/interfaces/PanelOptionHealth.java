package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PanelOptionHealth extends Panel implements View{
	
	private Image  imgHealth;
	private Label lblHealth;
	private Image imgReport;
	private Label lblReport;
	private Navigator navigator;
	private User user;
	
	
	public PanelOptionHealth (Navigator navigator,User user){
		
	this.navigator = navigator;
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
	
	this.lblHealth = new Label("Entidad salud");
	this.lblHealth.setVisible(true);
	
	
	this.imgReport = new Image("Certificado");
	ThemeResource resource2 = new ThemeResource("../Imagen/certificado.png");
	imgReport = new Image(null , resource2);
	this.imgReport.setWidth("100px");
	this.imgReport.setHeight("100px");
	this.imgReport.setVisible(true);
	
	this.imgReport.addClickListener(new ClickListener() {
		
		@Override
		public void click(ClickEvent event) {
			MembershipCertificate certificate = new MembershipCertificate(navigator,user);
			UI.getCurrent().addWindow(certificate);
			
		}
	});
	
	
	this.lblReport = new Label("Reporte");
	this.lblReport.setVisible(true);
	
	verticalHealth.addComponent(imgHealth);
	verticalHealth.addComponent(lblHealth);
	
	verticalReport.addComponent(imgReport);
	verticalReport.addComponent(lblReport);
	
	
	formLayout.addComponent(verticalHealth);
	formLayout.addComponent(verticalReport);
	
		
	setContent(formLayout);
	
	
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

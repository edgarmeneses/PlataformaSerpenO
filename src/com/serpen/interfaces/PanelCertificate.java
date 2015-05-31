package com.serpen.interfaces;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class PanelCertificate extends Panel  implements View{

	private Label lblTitle;
	private Label Description; 
	private Label Description2; 
	private Label Description3; 
	private Label Description4;
	private Label Description5; 
	private Button btnSave;
	private Button btnReturn;
	private Panel pnlPrincipal;
	
	
	public PanelCertificate(){
		
		FormLayout formGeneral = new  FormLayout();
		formGeneral.setVisible(true);
		
		FormLayout formPanel = new FormLayout();
		formPanel.setVisible(true);
		
		HorizontalLayout layoutTitle = new HorizontalLayout();
		layoutTitle.setVisible(true);
		
		HorizontalLayout layoutDescription = new HorizontalLayout();
		layoutDescription.setVisible(true);
		
		HorizontalLayout layoutDescription2 = new HorizontalLayout();
		layoutDescription2.setVisible(true);
		
		HorizontalLayout layoutDescription3 = new HorizontalLayout();
		layoutDescription3.setVisible(true);
		
		HorizontalLayout layoutDescription4 = new HorizontalLayout();
		layoutDescription4.setVisible(true);
		
		HorizontalLayout layoutDescription5 = new HorizontalLayout();
		layoutDescription5.setVisible(true);
		
		HorizontalLayout layoutButton = new HorizontalLayout();
		layoutButton.setVisible(true);
		
		pnlPrincipal = new Panel();
		pnlPrincipal.setWidth("500px");
		pnlPrincipal.setHeight("400px");
		this.pnlPrincipal.setVisible(true);
		
		lblTitle = new Label("CERTIFICADO DE AFILIACIÓN");
		this.lblTitle.setVisible(true);
		
		Description = new Label("Colombiana de salud se permite informar que la afiliado(a)");
		this.Description.setVisible(true);
		
		Description2 = new Label("DANIELA ALEXANDRA BLANCO ALBARRACÍN identificada con ");
		this.Description2.setVisible(true);
		
		Description3 = new Label("CC- 1049432560, esta vinculada al sistema General de ");
		this.Description3.setVisible(true);
		
		Description4 = new Label("seguridad social en salud régimen contributivo por intermedio ");
		this.Description4.setVisible(true);
		
		Description5 = new Label("de Colombiana de salud; y su estado es ACTIVO.");
		this.Description5.setVisible(true);
		
		btnSave = new Button("Guardar");
		this.btnSave.setVisible(true);
		
		btnReturn = new Button("Regresar");
		this.btnReturn.setVisible(true);
		
	
		formGeneral.addComponent(pnlPrincipal);
		
		layoutTitle.addComponent(lblTitle);
		layoutDescription.addComponent(Description);
		layoutDescription2.addComponent(Description2);
		layoutDescription3.addComponent(Description3);
		layoutDescription4.addComponent(Description4);
		layoutDescription5.addComponent(Description5);
		layoutButton.addComponent(btnSave);
		layoutButton.addComponent(btnReturn);
		
		formPanel.addComponent(layoutTitle);
		formPanel.addComponent(layoutDescription);
		formPanel.addComponent(layoutDescription2);
		formPanel.addComponent(layoutDescription3);
		formPanel.addComponent(layoutDescription4);
		formPanel.addComponent(layoutDescription5);
		formPanel.addComponent(layoutButton);
		
		this.pnlPrincipal.setContent(formPanel);
		this.setContent(formGeneral);
		this.setSizeFull();
				
		
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}

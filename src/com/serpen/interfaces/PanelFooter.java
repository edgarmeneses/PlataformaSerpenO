package com.serpen.interfaces;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * Panel que contiene el pie de pagina de la plataforma serpen
 * @author USER
 *
 */
public class PanelFooter extends Panel{
	
	private Label labelCopyrigth;
	private Label labelMail;
	
	public PanelFooter() {
		// TODO Auto-generated constructor stub
		
		FormLayout formLayout = new FormLayout();
		formLayout.setVisible(true);
		
		HorizontalLayout horizontalLayout = new  HorizontalLayout();
		HorizontalLayout horizontalLayout2 = new HorizontalLayout();
		
		horizontalLayout.setVisible(true);
		
		this.labelCopyrigth= new Label("Copyrigth@2015 Todos los derechos  reservados");
		this.labelCopyrigth.setVisible(true);
		
		this.labelMail = new Label("serpen@gmail.com");
		this.labelMail.setVisible(true);
		
		setContent(formLayout);
		
		formLayout.addComponent(horizontalLayout);
		formLayout.addComponent(horizontalLayout2);
		
		horizontalLayout.addComponent(labelCopyrigth);
		horizontalLayout2.addComponent(labelMail);
		
		
		
	}
	

}

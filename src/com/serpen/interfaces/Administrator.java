package com.serpen.interfaces;

import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.omg.CORBA.OMGVMCID;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component.Event;
/**
 * Universidad pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala 
 *         Daniela Blanco
 *         Diana Gonzalez
 *         Edgar Meneses
 *         Version 1.0
 *Clase que se encarga de pintar la pantalla de Administrador 
 *extiende de Custom Componente e implementa View
 */
public class Administrator extends CustomComponent implements View{

	public static final String NAMEADMINISTRATOR="Administrador";
	private PanelAdministrator paneAdministrator;
	private User user;
	private ControlGeneral control;
	private PanelFooter panelFooter;

	public Administrator (Navigator navigator, User user, ControlGeneral control){

		FormLayout layout = new FormLayout();
		paneAdministrator = new PanelAdministrator(navigator,user,control);
		panelFooter = new PanelFooter();
		
		setCompositionRoot(layout);
	
	    layout.addComponent(paneAdministrator);	
	    layout.addComponent(panelFooter);
	    	
		setSizeFull();
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}



}

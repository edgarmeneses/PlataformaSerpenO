package com.serpen.interfaces;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Panel;

public class PanelOptionsUser extends CustomComponent {

	private MenuBar menuBar;
	private MenuItem user;
	private MenuItem configuraton;
	private MenuItem logOut;
	
	public PanelOptionsUser(){
		
		menuBar = new MenuBar();
//		this.setVisible(menuBar);
		
		user = menuBar.addItem("USER", new ThemeResource("../Imagen/sesion.png"), null);
		
		configuraton = user.addItem("Configuración", null, null);
		logOut = user.addItem("Cerrar Sesión", null , null);
		
		setCompositionRoot(menuBar);
		
		
		
	}
}

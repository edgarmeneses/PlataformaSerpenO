package com.serpen.interfaces;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class PanelGeneral extends Panel{

	private Image User;
	private Image fondoPesions;
	private Label lblfondoPesions;
	private Image imgBank;
	private Label lblBank;
	private Image imgHealth;
	private Label lblHealth;

	public PanelGeneral() {
	
		// TODO Auto-generated constructor stub
		
		
		FormLayout layoutPanelOption = new FormLayout();
		layoutPanelOption.setSizeFull();
		layoutPanelOption.setVisible(true);	

		VerticalLayout verticalUser = new VerticalLayout();	
		VerticalLayout verticalFondoPensions = new VerticalLayout();	
		VerticalLayout verticalBank = new VerticalLayout();	
		VerticalLayout verticalHealth = new VerticalLayout();

		this.User = new Image("Usuario");
		ThemeResource resource3 = new ThemeResource("../Imagen/sesion.png");
		User = new Image(null, resource3);
		this.User.setWidth("50px");
		this.User.setHeight("50px");
		this.User.setVisible(true);

		this.fondoPesions = new Image("Fondo pensiones");
		ThemeResource resource4 = new ThemeResource("../Imagen/fondopension.png");
		fondoPesions = new Image(null, resource4);
		this.fondoPesions.setWidth("50px");
		this.fondoPesions.setHeight("50px");
		this.fondoPesions.setVisible(true);

		this.lblfondoPesions = new Label("Fondo Pensión");
		this.setVisible(true);

		this.imgBank = new Image("Entidad Banco");
		ThemeResource resource5 = new ThemeResource("../Imagen/banco.png");
		imgBank = new Image(null, resource5);
		this.imgBank.setWidth("50px");
		this.imgBank.setHeight("50px");
		this.imgBank.setVisible(true);

		lblBank = new Label("Entidad Bancaria");
		this.lblBank.setVisible(true);

		this.imgHealth = new Image("Entidad Salud");
		ThemeResource resource6 = new ThemeResource("../Imagen/entidadsalud.png");
		imgHealth = new Image(null, resource6);
		this.imgHealth.setWidth("50px");
		this.imgHealth.setHeight("50px");
		this.imgHealth.setVisible(true);

		lblHealth = new Label("Entidad Salud");
		this.lblHealth.setVisible(true);

		verticalUser.addComponent(User);

		verticalFondoPensions.addComponent(fondoPesions);
		verticalFondoPensions.addComponent(lblfondoPesions);

		verticalBank.addComponent(imgBank);
		verticalBank.addComponent(lblBank);

		verticalHealth.addComponent(imgHealth);
		verticalHealth.addComponent(lblHealth);
		
		layoutPanelOption.addComponent(verticalUser);
	    layoutPanelOption.addComponent(verticalFondoPensions);
	    layoutPanelOption.addComponent(verticalBank);
	    layoutPanelOption.addComponent(verticalHealth);
	    
	    setContent(layoutPanelOption);

	}

}

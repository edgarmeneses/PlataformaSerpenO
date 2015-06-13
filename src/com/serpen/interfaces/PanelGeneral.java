package com.serpen.interfaces;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.MenuItem;

public class PanelGeneral extends Panel implements View{

	private Image User;
	private Image fondoPesions;
	private Label lblfondoPesions;
	private Image imgBank;
	private Label lblBank;
	private Image imgHealth;
	private Label lblHealth;
	public static String NAMEPANELGENERAL = "";
	private Navigator navigator;
	
	private MenuBar menuBar;
	private MenuItem user;
	private MenuItem configuraton;
	private MenuItem logOut;
	

	public PanelGeneral(Navigator navigator) {
	
		// TODO Auto-generated constructor stub
		this.navigator = navigator; 
		
		FormLayout layoutPanelOption = new FormLayout();
		layoutPanelOption.setSizeFull();
		layoutPanelOption.setVisible(true);	

		VerticalLayout verticalUser = new VerticalLayout();	
		VerticalLayout verticalFondoPensions = new VerticalLayout();	
		VerticalLayout verticalBank = new VerticalLayout();	
		VerticalLayout verticalHealth = new VerticalLayout();

//		this.User = new Image("Usuario");
//		ThemeResource resource3 = new ThemeResource("../Imagen/sesion.png");
//		User = new Image(null, resource3);
//		this.User.setWidth("50px");
//		this.User.setHeight("50px");
//		this.User.setVisible(true);
		
		menuBar = new MenuBar();
//		this.setVisible(menuBar);
		
		user = menuBar.addItem("User", new ThemeResource("../Imagen/sesion.png"), null);
		
		configuraton = user.addItem("Configuración", null, null);
		logOut = user.addItem("Cerrar Sesión", null , null);
		
		setContent(menuBar);
		

		this.fondoPesions = new Image("Fondo pensiones");
		ThemeResource resource4 = new ThemeResource("../Imagen/fondopension.png");
		fondoPesions = new Image(null, resource4);
		this.fondoPesions.setWidth("50px");
		this.fondoPesions.setHeight("50px");
		this.fondoPesions.setVisible(true);
		
		this.fondoPesions.addClickListener(new ClickListener() {
			
			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(Simulator.NAMESIMULATOR,  new Simulator(navigator));
				navigator.navigateTo(Simulator.NAMESIMULATOR);
			}
		});

		this.lblfondoPesions = new Label("Fondo Pensión");
		this.setVisible(true);

		this.imgBank = new Image("Entidad Banco");
		ThemeResource resource5 = new ThemeResource("../Imagen/bancogeneral.png");
		imgBank = new Image(null, resource5);
		this.imgBank.setWidth("50px");
		this.imgBank.setHeight("50px");
		this.imgBank.setVisible(true);
		this.imgBank.addClickListener(new ClickListener() {
			
			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
			
				  navigator.addView(EntityBank.NAMEENTITYBANK,  new EntityBank(navigator));
				  navigator.navigateTo(EntityBank.NAMEENTITYBANK);
			}
		});;

		lblBank = new Label("Entidad Bancaria");
		this.lblBank.setVisible(true);

		this.imgHealth = new Image("Entidad Salud");
		ThemeResource resource6 = new ThemeResource("../Imagen/entidadsalud.png");
		imgHealth = new Image(null, resource6);
		this.imgHealth.setWidth("50px");
		this.imgHealth.setHeight("50px");
		this.imgHealth.setVisible(true);
		
		this.imgHealth.addClickListener(new ClickListener() {
			
			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				  navigator.addView(EntityHealth.NAMESENTITYHEALTH,  new EntityHealth(navigator));
				  navigator.navigateTo(EntityHealth.NAMESENTITYHEALTH);
			}
		});

		lblHealth = new Label("Entidad Salud");
		this.lblHealth.setVisible(true);

		verticalUser.addComponent(menuBar);

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

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

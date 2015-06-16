package com.serpen.interfaces;

import com.serpen.logic.entity.*;
import com.serpen.persistence.control.ControlGeneral;
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

public class PanelGeneralAdministrator extends Panel implements View{

	private Image User;
	private Image ImgnewUser;
	private Image imgList;
	private Image imgEdit;
	private Image imgConfig;
	private Image imgNewRol;
	private Image imgRol;
	
	public static String NAMEPANELGENERAL = "";
	private Navigator navigator;
	private User userD;
	private MenuBar menuBar;
	private MenuItem user;
	private MenuItem configuraton;
	private MenuItem logOut;
	

	public PanelGeneralAdministrator(Navigator navigator, User userD, ControlGeneral control) {
	
		// TODO Auto-generated constructor stub
		this.navigator = navigator; 
		this.userD=userD;
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
		

		this.ImgnewUser = new Image("Crear");
		ThemeResource resource1 = new ThemeResource("../Imagen/crear.png");
		ImgnewUser =new Image (null, resource1);
		ImgnewUser.addClickListener(new ClickListener() {

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(HomePageCreateUser.NAMEHOMECREATEUSER, new HomePageCreateUser(userD,navigator,control));
				navigator.navigateTo(HomePageCreateUser.NAMEHOMECREATEUSER);
			}
		});

		this.ImgnewUser.setVisible(true);
		
		this.setVisible(true);

		this.imgList= new Image("Listar");
		ThemeResource resource2 = new ThemeResource("../Imagen/buscar.png");
		imgList =new Image (null, resource2);
		this.imgList.setVisible(true);
		imgList.addClickListener(new ClickListener() {

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(List.NAMELIST, new List(navigator, userD,control));
				navigator.navigateTo(List.NAMELIST);
			}
		});

		this.imgEdit= new Image("Editar");
		ThemeResource resource3 = new ThemeResource("../Imagen/editar.png");
		imgEdit =new Image (null, resource3);
		this.imgEdit.setVisible(true);
		imgEdit.addClickListener(new ClickListener(){

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(HomePageEditUser.NAMEHOMEEDITUSEER, new HomePageEditUser(userD, navigator, control));
				navigator.navigateTo(HomePageEditUser.NAMEHOMEEDITUSEER);
			}

		});
		
		this.imgNewRol = new Image("Rol");
		ThemeResource resource5 = new ThemeResource("../Imagen/role.png");
		imgNewRol= new Image(null, resource5);
		this.imgNewRol.setVisible(true);
		imgNewRol.setWidth("50px");
		imgNewRol.setHeight("50px");
		imgNewRol.addClickListener(new ClickListener(){

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(CreateRol.NAMECREATEROLE, new CreateRol(navigator, userD, control));
				navigator.navigateTo(CreateRol.NAMECREATEROLE);
			}

		});

		this.imgConfig= new Image("Configuracion");
		ThemeResource resource4 = new ThemeResource("../Imagen/configuracion.png");
		imgConfig =new Image (null, resource4);
		this.imgConfig.setVisible(true);
		this.imgConfig.setWidth("50px");
		this.imgConfig.setHeight("50px");
		imgConfig.addClickListener(new ClickListener(){

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(Configuration.NAMECONFIGURATION, new Configuration(navigator,userD,control));
				navigator.navigateTo(Configuration.NAMECONFIGURATION);
				System.out.println("hhhhh");
			}

		});


		this.imgRol = new Image("Rol");
		ThemeResource resource6 = new ThemeResource("../Imagen/rol.png");
		imgRol = new Image(null , resource6);
		this.imgRol.setVisible(true);
		this.imgRol.setWidth("50px");
		this.imgRol.setHeight("50px");
		imgRol.addClickListener(new ClickListener(){

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(ListRol.NAMELISTROLE, new ListRol(navigator, userD, control));
				navigator.navigateTo(ListRol.NAMELISTROLE);
			}

		});

		verticalUser.addComponent(menuBar);

		verticalFondoPensions.addComponent(this.ImgnewUser);
		verticalFondoPensions.addComponent(this.imgList);

		verticalBank.addComponent(this.imgEdit);
		verticalBank.addComponent(this.imgNewRol);

		verticalHealth.addComponent(this.imgRol);
		verticalHealth.addComponent(this.imgConfig);
		
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

	public Image getImgnewUser() {
		return ImgnewUser;
	}

	public void setImgnewUser(Image imgnewUser) {
		ImgnewUser = imgnewUser;
	}

	public Image getImgList() {
		return imgList;
	}

	public void setImgList(Image imgList) {
		this.imgList = imgList;
	}

	public Image getImgEdit() {
		return imgEdit;
	}

	public void setImgEdit(Image imgEdit) {
		this.imgEdit = imgEdit;
	}

	public Image getImgConfig() {
		return imgConfig;
	}

	public void setImgConfig(Image imgConfig) {
		this.imgConfig = imgConfig;
	}

	public Image getImgNewRol() {
		return imgNewRol;
	}

	public void setImgNewRol(Image imgNewRol) {
		this.imgNewRol = imgNewRol;
	}

	public Image getImgRol() {
		return imgRol;
	}

	public void setImgRol(Image imgRol) {
		this.imgRol = imgRol;
	}

	public MenuItem getConfiguraton() {
		return configuraton;
	}


}

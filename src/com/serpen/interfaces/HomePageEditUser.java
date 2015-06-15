package com.serpen.interfaces;

import com.serpen.logic.entity.Agreement;
import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;


public class HomePageEditUser extends Panel implements TabSheet.SelectedTabChangeListener, View{

	public TabSheet tabsheet = new TabSheet();
	public User user;
	public PanelCreateUser createUser;
	public PanelDescriptionPensions descriptionPensions;
//	public EntityEducation education;
//	public HousingAgreement housing;
//	public TourismAgreement tourism ;
	public Navigator navigator;
	public ControlGeneral control;
	public static String NAMEHOMEEDITUSEER="TablaEditarUsuario";


	public HomePageEditUser(User user) {
		
		this.user=user;
		createUser= new PanelCreateUser(navigator, control);
		descriptionPensions= new PanelDescriptionPensions(navigator, control);

//		education = new EntityEducation();
//	    housing = new HousingAgreement(user);
//		tourism = new TourismAgreement(); 

		tabsheet.addTab(createUser, "Informacion de la Cuenta", null);
		tabsheet.getTab(createUser).setVisible(true);

		tabsheet.addTab(descriptionPensions, "Informacion Pesonal", null);
		tabsheet.getTab(descriptionPensions).setVisible(true);

		
//		tabsheet.addTab(education, "Educacion", null);
//		tabsheet.getTab(education).setVisible(true);

//		tabsheet.addTab(housing, "Vivienda", null);
//		tabsheet.getTab(housing).setEnabled(true);
//		
//		tabsheet.addTab(tourism, "Turismo", null);
//		tabsheet.getTab(tourism).setEnabled(true);
		
		setContent(tabsheet);
	}

	public void selectedTabChange(SelectedTabChangeEvent event) {

		final TabSheet source = (TabSheet) event.getSource();

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}


}


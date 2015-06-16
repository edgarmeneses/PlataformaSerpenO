package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase de la interfaz que se encarga de pintar la ventana de Create User
 *extiende de custom Componente e implementa  View
 */
public class HomePageCreateUser extends Panel implements TabSheet.SelectedTabChangeListener, View{

	private TabSheet tabsheet = new TabSheet();
	private User user;
	private PanelCreateUser createUser;
	private PanelPersonalInformation persdonalInformation;
	private PanelPensionFoundInformation foundInformation;
	public Navigator navigator;
	public ControlGeneral control;
	public static String NAMEHOMECREATEUSER="TablaCrearUsuario";
	private PanelGeneralAdministrator panelGeneral;


	public HomePageCreateUser(User user, Navigator navigator, ControlGeneral control) {
		
		this.user=user;
		
		createUser= new PanelCreateUser(navigator, control,NAMEHOMECREATEUSER);
		persdonalInformation= new PanelPersonalInformation(navigator, control,NAMEHOMECREATEUSER);
		foundInformation = new PanelPensionFoundInformation(navigator,control,NAMEHOMECREATEUSER);
		
		panelGeneral = new PanelGeneralAdministrator(navigator, user, control);
		panelGeneral.getImgnewUser().setEnabled(false);
		panelGeneral.setHeight("680px");

		tabsheet.addTab(createUser, "Informacion de la Cuenta", null);
		tabsheet.getTab(createUser).setVisible(true);

		tabsheet.addTab(persdonalInformation, "Informacion Pesonal", null);
		tabsheet.getTab(persdonalInformation).setVisible(true);
		
		tabsheet.addTab(foundInformation, "Informacion Fondo de Pensiones");
		tabsheet.getTab(foundInformation).setVisible(true);

		HorizontalLayout layout = new HorizontalLayout();
		
		layout.addComponent(tabsheet);
		layout.addComponent(panelGeneral);
	
		setContent(layout);
	}

	public void selectedTabChange(SelectedTabChangeEvent event) {

		final TabSheet source = (TabSheet) event.getSource();

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private void validateField(){
		
	}
}

package com.serpen.interfaces;

//import com.sun.xml.internal.bind.v2.util.FatalAdapter;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
/**
 * Clase convenio vivienda
 * @author Daniela Alexandra Blanco
 * @author Eliana Carolina Ayala
 * @author Diana Milena Gonzalez
 * @author Edgar Antonio Meneses
 *
 */
public class HousingAgreement extends CustomComponent implements View{
	
	private PanelHousingEntity entity;
	private PanelHousingServices services;
	private PanelGeneral options;
	private Navigator navigator;
	
	public HousingAgreement() {
		// TODO Auto-generated constructor stub
		HorizontalLayout layout = new HorizontalLayout();
		//layout.setSizeFull();
		layout.setVisible(true);
		
		entity = new PanelHousingEntity();
		setWidth("20%");
		
		services = new PanelHousingServices();
		services.setWidth("60%");
		
		options = new PanelGeneral(navigator);
		options.setWidth("20%");
		
		layout.addComponent(entity);
		layout.addComponent(services);
		layout.addComponent(options);
		
		setCompositionRoot(layout);
		setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	

}

package com.serpen.interfaces;

import com.sun.xml.internal.bind.v2.util.FatalAdapter;
import com.vaadin.ui.CustomComponent;
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
public class HousingAgreement extends CustomComponent{
	
	private Label featureTitle;
	
	private Label benefitTitle;
	
	private Label feature;
	
	private Label benefit;
	
	public HousingAgreement() {
		// TODO Auto-generated constructor stub
		VerticalLayout layout = new VerticalLayout();
		
		featureTitle = new Label("Caracteristicas");
		featureTitle.setWidth("120px");
		featureTitle.setHeight("280px");
		
		feature = new Label("Caractristicas....");
		feature.setWidth("120px");
		feature.setHeight("100px");
		
		benefitTitle = new Label("Beneficios:");
		benefitTitle.setWidth("120px");
		benefitTitle.setHeight("150px");
	
		benefit = new Label("Beneficios: -.......");
		benefit.setWidth("120px");
		benefit.setHeight("200px");
		
		layout.addComponent(featureTitle);
		layout.addComponent(feature);
		layout.addComponent(benefitTitle);
		layout.addComponent(benefit);
		
		setCompositionRoot(layout);
	
	}
	
	

}

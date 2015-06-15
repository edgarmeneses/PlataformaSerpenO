package com.serpen.interfaces;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

public class TourismAgreement extends CustomComponent{

	private PanelOptionTourism optionTourism;
	private PanelTourism panelTourism;
	
	public TourismAgreement (){
		
		HorizontalLayout  horizontalLayout = new HorizontalLayout();
		horizontalLayout.setVisible(true);
		
		optionTourism = new PanelOptionTourism();
		panelTourism = new PanelTourism();
		
		horizontalLayout.addComponent(optionTourism);
		horizontalLayout.addComponent(panelTourism);
		
		setCompositionRoot(horizontalLayout);
		setSizeFull();
		
	}
	
	
}

package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class EntityBank extends CustomComponent implements  View{

	private PanelOptionBank panelOptionBank;
	private PanelGeneral panelGeneral;
	private PanelTableBank panelTableBank;
	public static String NAMEENTITYBANK = "EntityBank";
	
	private Navigator navigator;
	
	
	public EntityBank(Navigator navigator){
		
		this.navigator = navigator;
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setVisible(true);
		
		panelOptionBank = new PanelOptionBank(navigator);
		panelTableBank = new PanelTableBank();
		panelTableBank.setVisible(true);
		panelGeneral = new PanelGeneral(navigator);
		
		horizontalLayout.addComponent(panelOptionBank);
		horizontalLayout.addComponent(panelTableBank);
		horizontalLayout.addComponent(panelGeneral);
		
		setCompositionRoot(horizontalLayout);
		setSizeFull();
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	} 
	
}

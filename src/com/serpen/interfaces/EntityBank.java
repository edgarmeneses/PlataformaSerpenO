package com.serpen.interfaces;

import com.serpen.logic.entity.User;
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
	private User user;
	
	public EntityBank(Navigator navigator, User user){
		
		this.navigator = navigator;
		this.user=user;
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setVisible(true);
		
		panelOptionBank = new PanelOptionBank(navigator);
		panelTableBank = new PanelTableBank(navigator);
		panelTableBank.setVisible(true);
		panelGeneral = new PanelGeneral(navigator,user);
		
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

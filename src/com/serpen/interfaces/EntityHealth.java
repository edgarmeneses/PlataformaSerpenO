package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class EntityHealth extends CustomComponent implements View {

	private PanelOptionHealth panelOptionHealth;
	private PanelGeneral general;
	private  Navigator navigator;
	private PanelTable  panelTable;
	public static String NAMESENTITYHEALTH="EntityHealth";
	private User user;
	
	public EntityHealth(Navigator navigator, User user){
		
		
    	this.navigator = navigator;
    	 this.user=user;
    	
    	FormLayout layoutPrincipal= new FormLayout();
 		layoutPrincipal.setSizeFull();
 		layoutPrincipal.beforeClientResponse(false);
 		layoutPrincipal.setVisible(true);
 		layoutPrincipal.setStyleName("v-SIDEBAR");
 		
	    HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setVisible(true);
		
		panelOptionHealth = new PanelOptionHealth(navigator,user);
		panelTable = new PanelTable(navigator);
		panelTable.setVisible(true);
		general = new PanelGeneral(navigator,user);
		
		horizontalLayout.addComponent(panelOptionHealth);
		horizontalLayout.addComponent(panelTable);
		horizontalLayout.addComponent(general);
		
		layoutPrincipal.addComponent(horizontalLayout);
		setCompositionRoot(layoutPrincipal);
		setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}

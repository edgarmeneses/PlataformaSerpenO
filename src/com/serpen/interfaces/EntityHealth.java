package com.serpen.interfaces;

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
	
	public EntityHealth(Navigator navigator){
		
    	this.navigator = navigator;
	    HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setVisible(true);
		
		panelOptionHealth = new PanelOptionHealth(navigator);
		panelTable = new PanelTable(navigator);
		panelTable.setVisible(true);
		general = new PanelGeneral();
		
		horizontalLayout.addComponent(panelOptionHealth);
		horizontalLayout.addComponent(panelTable);
		horizontalLayout.addComponent(general);

		
		setCompositionRoot(horizontalLayout);
		setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}

package com.serpen.interfaces;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class EntityHealth extends CustomComponent {

	private PanelOptionHealth panelOptionHealth;
	private PanelGeneral general;
	private PanelTableService  panelTableService;
	
	public EntityHealth(){
		
		FormLayout formLayout = new FormLayout();
		
		HorizontalLayout verticalLayout = new HorizontalLayout();
		
		general = new PanelGeneral();
		general.setWidth("200px");
		general.setHeight("500px");
		
		panelOptionHealth = new PanelOptionHealth();
		general = new PanelGeneral();
		panelTableService = new PanelTableService();
		
		verticalLayout.addComponent(panelOptionHealth);
		verticalLayout.addComponent(panelTableService);
		verticalLayout.addComponent(general);

		
		formLayout.addComponent(verticalLayout);
		setCompositionRoot(formLayout);
	}
	
}

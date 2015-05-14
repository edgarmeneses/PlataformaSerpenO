package com.serpen.interfaces;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;



public class BoardReport extends CustomComponent{
	private PanelBoardReport panelAdministrator;
	
	public BoardReport() {
		// TODO Auto-generated constructor stub
		
		FormLayout formLayout = new FormLayout();
		formLayout.setVisible(true);
		
		panelAdministrator = new PanelBoardReport();
		panelAdministrator.setWidth("500px");
		panelAdministrator.setHeight("500px");
		panelAdministrator.setVisible(true);	
		
		formLayout.addComponent(panelAdministrator);
		setCompositionRoot(formLayout);	
	}
}

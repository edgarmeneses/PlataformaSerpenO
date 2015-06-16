package com.serpen.interfaces;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WindowsSimulator extends  Window {
	
	private PanelSimulator panelSimulator;
	private Navigator navigator;
	
	public WindowsSimulator(Navigator navigator){
		
		this.navigator=navigator;
//		super("Simulador");
//		center();
		setWidth("500px");
		setHeight("500px");
		
		FormLayout layoutPrincipal= new FormLayout();
		layoutPrincipal.setSizeFull();
		layoutPrincipal.beforeClientResponse(false);
		layoutPrincipal.setVisible(true);
		layoutPrincipal.setStyleName("v-SIDEBAR");
		
		VerticalLayout layout = new VerticalLayout();
		this.panelSimulator = new PanelSimulator();
		layout.addComponent(panelSimulator);
		layout.setMargin(true);
	    
		layoutPrincipal.addComponent(layout);
		
		setContent(layoutPrincipal);
		
	}


}

package com.serpen.interfaces;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WindowsSimulator extends  CustomComponent{
	
	private PanelSimulator panelSimulator;
	
	public WindowsSimulator(){
//		super("Simulador");
//		center();
		setWidth("500px");
		setHeight("500px");
		
		VerticalLayout layout = new VerticalLayout();
		this.panelSimulator = new PanelSimulator();
		layout.addComponent(panelSimulator);
		layout.setMargin(true);
		setCompositionRoot(layout);
	}

}

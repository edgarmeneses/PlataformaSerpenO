package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WindowBank extends Window{

	private PanelWindowBank panelWindowBank;
	private Navigator navigator;
	public static final String NAMEwINDOWSBANK="windowsBank";
	
	public WindowBank(Navigator navigator){
		
		this.navigator = navigator;
		setWidth("900px");
		setHeight("600px");
		
	    VerticalLayout layout = new VerticalLayout();
	    
	    this.panelWindowBank = new PanelWindowBank();
	    layout.addComponent(panelWindowBank);
	    layout.setMargin(true);
	    setContent(layout);
	    
	    	
	}
	 
}

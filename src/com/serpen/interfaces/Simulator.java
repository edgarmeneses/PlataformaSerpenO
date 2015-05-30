package com.serpen.interfaces;

import com.vaadin.client.ui.VHorizontalLayout;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.UI;

public class Simulator extends CustomComponent implements View{
	
	
	private PanelFoundConf panelFoundConf;
	private PanelGeneral   panelGeneral;
	private  Navigator navigator;
	public static String NAMESIMULATOR="Simulator";

	public  Simulator (Navigator navigator){
		
		FormLayout formLayout = new FormLayout();
		
		VerticalLayout horizontalLayout =  new VerticalLayout();
		
		panelFoundConf = new PanelFoundConf(navigator);

		
		panelGeneral = new PanelGeneral();
		panelGeneral.setWidth("200px");
		panelGeneral.setHeight("500px");
		
		horizontalLayout.addComponent(panelFoundConf);
		horizontalLayout.addComponent(panelGeneral);
		
	    formLayout.addComponent(horizontalLayout);
		setCompositionRoot(formLayout);
				
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	

}

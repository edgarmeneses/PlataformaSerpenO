package com.serpen.interfaces;

import com.serpen.logic.entity.User;
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
	private HomePageFound homePageFound ;
	public static String NAMESIMULATOR="Simulator";
	private User user;

	public  Simulator (Navigator navigator, User user){
		
		this.user=user;
		System.out.println("FOndo"+user);
		FormLayout formLayout = new FormLayout();
		
		VerticalLayout horizontalLayout =  new VerticalLayout();
		
		homePageFound = new HomePageFound(user);
		panelFoundConf = new PanelFoundConf(navigator,user);
        
		
		panelGeneral = new PanelGeneral(navigator,user);
		panelGeneral.setWidth("200px");
		panelGeneral.setHeight("500px");
		
		horizontalLayout.addComponent(panelFoundConf);
		horizontalLayout.addComponent(homePageFound);
		horizontalLayout.addComponent(panelGeneral);
		
	    formLayout.addComponent(horizontalLayout);
		setCompositionRoot(formLayout);			
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub	
	}
}

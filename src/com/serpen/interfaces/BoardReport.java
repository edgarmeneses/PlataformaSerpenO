package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlUser;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Window;



public class BoardReport extends Window {
	
	
	private PanelBoardReport panelBoardReport;
	private Navigator navigator;
	private ControlUser controlUser;
	private User user;
	
	public BoardReport(Navigator navigator, User user) {
		
		this.navigator=navigator;
		// TODO Auto-generated constructor stub
		this.user=user;
		System.out.println("reporte"+user);
		FormLayout formLayout = new FormLayout();
		formLayout.setVisible(true);
		
		panelBoardReport = new PanelBoardReport(navigator,user);
		panelBoardReport.setWidth("800px");
		panelBoardReport.setHeight("800px");
		panelBoardReport.setVisible(true);	
		
		formLayout.addComponent(panelBoardReport);	
		setContent(formLayout);
	}
}

package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Window;



public class BoardReport extends Window {
	
	
	private PanelBoardReport panelBoardReport;
	private Navigator navigator;
	public BoardReport(Navigator navigator) {
		
		this.navigator=navigator;
		// TODO Auto-generated constructor stub
		
		FormLayout formLayout = new FormLayout();
		formLayout.setVisible(true);
		
		panelBoardReport = new PanelBoardReport(navigator);
		panelBoardReport.setWidth("800px");
		panelBoardReport.setHeight("800px");
		panelBoardReport.setVisible(true);	
		
		formLayout.addComponent(panelBoardReport);	
		setContent(formLayout);
	}
}

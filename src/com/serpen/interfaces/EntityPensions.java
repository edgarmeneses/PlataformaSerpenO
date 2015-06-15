package com.serpen.interfaces;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;

public class EntityPensions extends CustomComponent implements View{

	private PanelDescriptionPensions Panelpensions;


	public EntityPensions() {
		// TODO Auto-generated constructor stub
		FormLayout layout = new FormLayout();
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setVisible(true);
		
//		Panelpensions= new PanelDescriptionPensions();
		
		horizontalLayout.addComponent(Panelpensions);
		
		layout.addComponent(horizontalLayout);
		setCompositionRoot(layout);
		setSizeFull();
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}

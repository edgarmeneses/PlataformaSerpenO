package com.serpen.interfaces;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;

public class EntityEducation extends CustomComponent implements View{

	
	private PanelEntityEducation panelEducation;
	private PanelServiceEducation pServiceEducation;
	
	
	public EntityEducation() {
		
		FormLayout layout = new FormLayout();
	
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setVisible(true);
		
		panelEducation= new PanelEntityEducation();
		
		
		pServiceEducation = new PanelServiceEducation();
		
		horizontalLayout.addComponent(panelEducation);
		horizontalLayout.addComponent(pServiceEducation);
		
		layout.addComponent(horizontalLayout);
		setCompositionRoot(layout);
		setSizeFull();
		

	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

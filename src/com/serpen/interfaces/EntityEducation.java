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
		
		//FormLayout layout = new FormLayout();
	
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setVisible(true);
		
		///FormLayout horizontal = new FormLayout();
		//horizontal.setVisible(true);
		
		panelEducation= new PanelEntityEducation();
		
		
		pServiceEducation = new PanelServiceEducation();
		pServiceEducation.setVisible(true);
		
		horizontalLayout.addComponent(panelEducation);
		horizontalLayout.addComponent(pServiceEducation);
		
		//horizontal.addComponent(horizontalLayout);
		//layout.addComponent(horizontal);
		setCompositionRoot(horizontalLayout);
		setSizeFull();
		

	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

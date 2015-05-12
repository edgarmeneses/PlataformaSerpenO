package com.serpen.interfaces;

import com.serpen.logic.entity.Agreement;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;

public class HomePageFound extends CustomComponent{
	
	private TabSheet menu;
	
	public HomePageFound() {
		VerticalLayout layout = new VerticalLayout();
		
		menu = new TabSheet();
		
		menu.addTab(new HousingAgreement(), "Informacion General");
		menu.addTab(new HousingAgreement(), "Educacion");
		menu.addTab(new HousingAgreement(), "Vivienda");
		menu.addTab(new TourismAgreement(), "Turismo");
		
//		menu.addSelectedTabChangeListener(new TabSheet.SelectedTabChangeListener() {
//			
//			@Override
//			public void selectedTabChange(SelectedTabChangeEvent event) {
//				// TODO Auto-generated method stub
//				TabSheet tabSheet = event.getTabSheet();
//				
//				Layout content = (Layout) tabSheet.getSelectedTab();
//				content.removeAllComponents();
//				String caption = tabSheet.getTab(layout).getCaption();
//				addComponet(layout, caption);
//				
//			}
//		});
		
		layout.addComponent(menu);
		
		setCompositionRoot(layout);
		setSizeFull();
		
	}
	
	public void addComponet(Layout layout, String caption){
		switch (caption) {
		case "Vivienda":
			layout.addComponent(new HousingAgreement());
			break;
		case "Educacion":
			layout.addComponent(new Label("Educacion...."));
			break;
		default:
			break;
		}
	}
	
	
	

}

package com.serpen.interfaces;


import org.apache.catalina.startup.SetContextPropertiesRule;

import com.serpen.logic.entity.Agreement;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;


public class HomePageFound extends Panel implements TabSheet.SelectedTabChangeListener {

	public TabSheet tabsheet = new TabSheet();


	public EntityPensions pensions = new EntityPensions();
	public EntityEducation education = new EntityEducation();
	public HousingAgreement housing = new HousingAgreement();
	public TourismAgreement tourism = new TourismAgreement(); 
//	public Label tab1 = new Label("holaaa1");
//	public Label tab2 = new Label("holaa2");
//	public Label tab3 = new Label("hola3");
//	public Label tab4 = new Label("holaaaa4");

	public HomePageFound() {
		tabsheet.addListener(this);

		tabsheet.addTab(pensions, "Informacion General", null);
		tabsheet.getTab(pensions).setVisible(true);

		tabsheet.addTab(education, "Educacion", null);
		tabsheet.getTab(education).setVisible(true);

		tabsheet.addTab(housing, "Vivienda", null);
		tabsheet.getTab(housing).setEnabled(true);
		
		tabsheet.addTab(tourism, "Turismo", null);
		tabsheet.getTab(tourism).setEnabled(true);
		
		setContent(tabsheet);
	}

	public void selectedTabChange(SelectedTabChangeEvent event) {

		final TabSheet source = (TabSheet) event.getSource();

	}


}

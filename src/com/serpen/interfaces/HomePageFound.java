package com.serpen.interfaces;


import org.apache.catalina.startup.SetContextPropertiesRule;

import com.serpen.logic.entity.Agreement;
import com.serpen.logic.entity.User;
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
	public User user;
	public EntityPensions  pensions ;
	public EntityEducation education;
	public HousingAgreement housing;
	public TourismAgreement tourism ;
//	public Label tab1 = new Label("holaaa1");
//	public Label tab2 = new Label("holaa2");
//	public Label tab3 = new Label("hola3");
//	public Label tab4 = new Label("holaaaa4");

	public HomePageFound(User user) {
		
		this.user=user;
		pensions = new EntityPensions();
		education = new EntityEducation();
	    housing = new HousingAgreement(user);
		tourism = new TourismAgreement(); 
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

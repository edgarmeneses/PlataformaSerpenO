package com.serpen.interfaces;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;



public class PanelEntityEducation extends Panel{
	
	private Panel pnlMenu;
	private Image ImgneUserEdu;
	private Label userlabel;

	
	public PanelEntityEducation() {

	FormLayout layoutPrin = new FormLayout();
	layoutPrin.setSizeFull();
	layoutPrin.setVisible(true);


	FormLayout layoutPanel = new FormLayout();
	layoutPanel.setSizeFull();
	layoutPanel.setVisible(true);

	
	HorizontalLayout horizontalLayout1 = new HorizontalLayout();
	VerticalLayout verticalLayout= new VerticalLayout();

	pnlMenu = new  Panel();
	pnlMenu.setSizeFull();
	pnlMenu.setWidth("200px");
	pnlMenu.setHeight("800px");

	this.ImgneUserEdu = new Image("Crear");
	ThemeResource resource = new ThemeResource("../Imagen/educacion.png");
	ImgneUserEdu =new Image (null, resource);
	ImgneUserEdu.setWidth("80px");
	ImgneUserEdu.setHeight("80px");
	this.ImgneUserEdu.setVisible(true);

	userlabel= new Label("U.P.T.C");
	userlabel.setWidth("50px");
	userlabel.setHeight("50px");
	userlabel.setVisible(true);
	
	layoutPrin.addComponent(pnlMenu);	

	
	horizontalLayout1.addComponent(ImgneUserEdu);
	verticalLayout.addComponent(userlabel);
     
	layoutPanel.addComponent(horizontalLayout1);
	layoutPanel.addComponent(verticalLayout);

	this.pnlMenu.setContent(layoutPanel);
//	this.pnlOption.setContent(layoutPanelt);
	setContent(layoutPrin);
	
	}

}
